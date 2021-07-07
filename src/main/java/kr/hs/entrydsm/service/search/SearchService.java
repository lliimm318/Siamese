package kr.hs.entrydsm.service.search;

import kr.hs.entrydsm.payload.response.SearchResponse;

import java.util.List;

public interface SearchService {

    List<SearchResponse> searchPostList(String searchWord);

}
