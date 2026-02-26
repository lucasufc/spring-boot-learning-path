package br.com.eurudio.model;

import br.com.eurudio.domain.Operation;

public record MathResponse(
    Double numberOne,
    Double numberTwo,
    Operation operation,
    Double result
) {}