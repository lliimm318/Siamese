package kr.hs.entrydsm.admin.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;
import kr.hs.entrydsm.admin.entity.Image;
import kr.hs.entrydsm.admin.entity.ImageRepository;
import kr.hs.entrydsm.admin.service.dto.ImageResponse;
import kr.hs.entrydsm.admin.service.exception.InvalidFileExtensionException;
import kr.hs.entrydsm.common.exception.BadRequestException;
import kr.hs.entrydsm.common.security.AuthMiddleware;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class ImageServiceImpl implements ImageService {
    private final ImageRepository imageRepository;

    private final AmazonS3 s3;

    private final ArrayList<String> allowedExtensions = new ArrayList<>(Arrays.asList(".JPG", ".JPEG", ".HEIC", ".PNG"));

    @Value("${aws.s3.bucket}")
    private String bucket;

    @Override
    public ImageResponse createImage(Optional<MultipartFile> file) throws IOException {
        MultipartFile parsedFile = file.orElseThrow(BadRequestException::new);

        String originalFilename = parsedFile.getOriginalFilename();
        String ext = originalFilename.substring(originalFilename.lastIndexOf("."));
        String filename = UUID.randomUUID().toString() + ext;

        if (allowedExtensions.stream().noneMatch(e -> e.equals(ext.toUpperCase()))) { throw new InvalidFileExtensionException(); }

        s3.putObject(new PutObjectRequest(bucket, "images/" + filename, parsedFile.getInputStream(), null)
                .withCannedAcl(CannedAccessControlList.AuthenticatedRead));

        Image image = imageRepository.save(Image.builder()
                .club(AuthMiddleware.currentClub())
                .path("https://" + bucket + "/images/" + filename)
                .build());

        return ImageResponse.builder().imagePath(image.getPath()).imageId(image.getId()).build();
    }
}
