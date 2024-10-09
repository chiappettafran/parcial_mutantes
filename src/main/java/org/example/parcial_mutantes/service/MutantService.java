package org.example.parcial_mutantes.service;

import org.example.parcial_mutantes.model.Dna;
import org.example.parcial_mutantes.repository.DnaRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class MutantService {

    private final DnaRepository dnaRepository;

    public MutantService(DnaRepository dnaRepository) {
        this.dnaRepository = dnaRepository;
    }

    public boolean isMutant(String[] dna) {
        boolean isMutant = checkIfMutant(dna);
        Dna dnaEntity = new Dna();
        dnaEntity.setDnaSequence(String.join(",", dna)); // Convertir array a cadena
        dnaEntity.setMutant(isMutant);
        dnaRepository.save(dnaEntity);

        return isMutant;
    }

    public Map<String, Object> getStats() {
        long mutants = dnaRepository.countByIsMutant(true);
        long humans = dnaRepository.countByIsMutant(false);

        Map<String, Object> stats = new HashMap<>();
        stats.put("count_mutant_dna", mutants);
        stats.put("count_human_dna", humans);
        stats.put("ratio", humans > 0 ? (double) mutants / humans : 0);

        return stats;
    }

    private boolean checkIfMutant(String[] dna) {
        int ocurrences = 0;
        for (int i = 0; i < dna.length; i++) {
            for (int j = 0; j < dna.length; j++) {
                if (i > dna.length - 4 && j > dna.length - 4) {
                    break;
                } else {
                    if (j <= dna.length - 4) {
                        if (dna[i].charAt(j) == dna[i].charAt(j + 1) && dna[i].charAt(j + 1) == dna[i].charAt(j + 2) && dna[i].charAt(j + 2) == dna[i].charAt(j + 3)) {
                            if (j != dna.length - 4) {
                                if (dna[i].charAt(j) != dna[i].charAt(j + 4)) {
                                    ocurrences++;
                                }
                            } else {
                                ocurrences++;
                            }
                            if (ocurrences == 2) {
                                return true;
                            }
                        }

                        if (i < dna.length - 3) {
                            if (dna[i].charAt(j) == dna[i + 1].charAt(j + 1) && dna[i + 1].charAt(j + 1) == dna[i + 2].charAt(j + 2) && dna[i + 2].charAt(j + 2) == dna[i + 3].charAt(j + 3)) {
                                if (i != dna.length - 4 && j != dna.length - 4) {
                                    if (dna[i].charAt(j) != dna[i + 4].charAt(j + 4)) {
                                        ocurrences++;
                                    }
                                } else {
                                    ocurrences++;
                                }
                                if (ocurrences == 2) {
                                    return true;
                                }
                            }
                        }
                    }

                    if (i <= dna.length - 4) {
                        if (dna[i].charAt(j) == dna[i + 1].charAt(j) && dna[i + 1].charAt(j) == dna[i + 2].charAt(j) && dna[i + 2].charAt(j) == dna[i + 3].charAt(j)){
                            if (i != dna.length - 4){
                                if (dna[i].charAt(j) != dna[i + 4].charAt(j)) {
                                    ocurrences++;
                                }
                            } else {
                                ocurrences++;
                            }
                            if (ocurrences == 2) {
                                return true;
                            }
                        }

                        if (j > 2) {
                            if (dna[i].charAt(j) == dna[i + 1].charAt(j - 1) && dna[i + 1].charAt(j - 1) == dna[i + 2].charAt(j - 2) && dna[i + 2].charAt(j - 2) == dna[i + 3].charAt(j - 3)) {
                                if (i != dna.length - 4) {
                                    if (dna[i].charAt(j) != dna[i + 4].charAt(j - 4)) {
                                        ocurrences++;
                                    }
                                } else {
                                    ocurrences++;
                                }
                                if (ocurrences == 2) {
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
}
