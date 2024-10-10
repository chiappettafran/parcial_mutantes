package org.example.parcial_mutantes.validations;

import org.example.parcial_mutantes.dto.DnaRequest;
import org.example.parcial_mutantes.exceptions.InvalidDnaException;

public abstract class Validations {
    public static void validateDna(DnaRequest dnaRequest) {
        String[] dna = getDna(dnaRequest);

        // Caso f: Validar si contiene letras distintas a {A, T, C, G}
        for (String row : dna) {
            if (!row.matches("[ATCG]+")) {
                throw new InvalidDnaException("El array DNA contiene caracteres inválidos. Solo se permiten A, T, C, G.");
            }
        }

        // Caso c: Validar si el array contiene números (se asume que están entre comillas)
        for (String row : dna) {
            if (row.matches(".*\\d.*")) {
                throw new InvalidDnaException("El array DNA contiene números, lo cual no es válido.");
            }
        }
    }

    private static String[] getDna(DnaRequest dnaRequest) {
        String[] dna = dnaRequest.getDna();

        // Caso d: Validar si se recibe null
        if (dna == null) {
            throw new InvalidDnaException("El array DNA no puede ser null.");
        }

        // Caso a: Validar si el array está vacío
        if (dna.length == 0) {
            throw new InvalidDnaException("El array DNA no puede estar vacío.");
        }

        int n = dna.length;

        // Caso b: Validar si el array no es NxN
        for (String row : dna) {
            if (row == null) { // Caso e: Filas null en el array
                throw new InvalidDnaException("El array DNA contiene filas null.");
            }
            if (row.length() != n) {
                throw new InvalidDnaException("El array DNA debe ser NxN.");
            }
        }
        return dna;
    }
}
