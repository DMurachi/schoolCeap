package com.bucares.barcode.utilities;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response<T> {

  private String code;

  private T data;

  private String message;

  public Response(String s, T data, String m) {
    this.code = s;
    this.data = data;
    this.message = m;
  }

    public String toJson() throws JsonProcessingException {
    ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();

    return ow.writeValueAsString(this);
  }

}
