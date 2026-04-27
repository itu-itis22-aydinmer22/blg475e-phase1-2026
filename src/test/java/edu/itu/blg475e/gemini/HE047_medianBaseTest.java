/* @Authors
 * Student Names: Mert Aydın, Oğuz Eren Kacar, Mehmet Enes Tekgöz
 * Student IDs:   150220722, 150200018, 150210089
 *
 * BLG 475E Software Quality and Testing - 2025-2026 Spring Term
 * Project: LLM-Based Code and Test Generation
 */
package edu.itu.blg475e.gemini;

import org.junit.jupiter.api.Test;
import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Base tests for HE047_median (LLM: GEMINI).
 * Converted from the HumanEval original test.
 * Minor modifications: reworded into JUnit 6 style; method calls rebound to the
 * LLM-generated class. NO changes to expected values.
 */
public class HE047_medianBaseTest {

    private final HE047_median sut = new HE047_median();

    @Test
    void baseHumanEvalAssertions() {
        assertTrue(sut.median(new ArrayList<>(Arrays.asList(3, 1, 2, 4, 5))) == 3, "base assertion 1");
        assertTrue(sut.median(new ArrayList<>(Arrays.asList(-10, 4, 6, 1000, 10, 20))) == 8.0, "base assertion 2");
        assertTrue(sut.median(new ArrayList<>(Arrays.asList(5))) == 5, "base assertion 3");
        assertTrue(sut.median(new ArrayList<>(Arrays.asList(6, 5))) == 5.5, "base assertion 4");
    }
}
