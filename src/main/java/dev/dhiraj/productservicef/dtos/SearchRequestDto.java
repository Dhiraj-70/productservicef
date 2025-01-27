package dev.dhiraj.productservicef.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter

public class SearchRequestDto {
    private String query;
    private int pageNumber;
    private int pageSize;
    private List<String> sortValue;
}
