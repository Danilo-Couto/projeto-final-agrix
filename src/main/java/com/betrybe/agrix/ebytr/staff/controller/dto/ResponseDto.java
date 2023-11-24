package com.betrybe.agrix.ebytr.staff.controller.dto;

public record ResponseDto<T>(String message, T data) {

}
