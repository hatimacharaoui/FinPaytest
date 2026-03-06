import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.esocial.service.CotisationService;

public class CotisationTest {

    @Test
    void testCotisation(){

        CotisationService service=new CotisationService();

        double result=service.cotisationSalariale(2000);

        assertEquals(80,result);

    }
}
