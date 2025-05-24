package com.empresa.brinquedos.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Brinquedo {
    @Serial
    private static final long serialVersionUID = 2273069510831781207L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nome é obrigatório")
    @Size(max = 100, message = "Nome deve ter no máximo 100 caracteres")
    private String nome;

    @NotBlank(message = "Tipo é obrigatório")
    @Size(max = 50, message = "Tipo deve ter no máximo 50 caracteres")
    private String tipo;

    @NotBlank(message = "Classificação é obrigatória")
    @Size(max = 20, message = "Classificação deve ter no máximo 20 caracteres")
    private String classificacao;

    @NotBlank(message = "Tamanho é obrigatório")
    @Size(max = 20, message = "Tamanho deve ter no máximo 20 caracteres")
    private String tamanho;

    @NotNull(message = "Preço é obrigatório")
    @Positive(message = "Preço deve ser positivo")
    private Double preco;

}