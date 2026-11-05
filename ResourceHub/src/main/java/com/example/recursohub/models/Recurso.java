package com.example.recursohub.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Recurso {
    private Long id;
    private String titulo;
    private String url;
    private String tipo;
    private String categoria;
}
