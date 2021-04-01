package kr.hs.entrydsm.admin.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotEmpty;

@Getter
@AllArgsConstructor
public class PostRequest {
    @NotEmpty
    private String title;

    private String author;

    @NotEmpty
    private String description;

    @NotEmpty
    private String content;

    @NotEmpty
    private String type;
}
