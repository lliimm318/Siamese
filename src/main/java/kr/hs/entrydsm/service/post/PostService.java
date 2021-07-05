package kr.hs.entrydsm.service.post;

import kr.hs.entrydsm.payload.response.MainPostResponse;

import java.util.List;

public interface PostService {

    List<MainPostResponse> getListPost();

}
