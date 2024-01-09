package org.example;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;



class CodeGeneratorTest {

    @BeforeEach
    void setUp() {
    }


    @Test
    void testValidCode() {
        GeneratorRanNumCode generator = new GeneratorRanNumCode();
        char oneChar = Integer.toString(1).charAt(0);
        char eightChar = Integer.toString(8).charAt(0);
        for(int i = 0; i < 50; i++){
            String code = generator.generateCode();
            code.chars().forEach(digit -> {
                assertTrue(digit >= oneChar && digit <= eightChar);
            });
        }
    }
}