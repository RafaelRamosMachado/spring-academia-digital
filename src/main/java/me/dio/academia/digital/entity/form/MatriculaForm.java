package me.dio.academia.digital.entity.form;

import javax.validation.constraints.Positive;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MatriculaForm {

  @javax.validation.constraints.NotNull(message = "Preencha o campo corretamente")	
  @Positive(message = "O Id do aluno precisa ser positivo.")
  private Long alunoId;

}
