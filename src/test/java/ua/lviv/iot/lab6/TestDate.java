package ua.lviv.iot.lab6;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Scanner;

import org.junit.jupiter.api.Test;

class TestDate {

    private Date date = new Date();

    @Test
    public void testOfDate() {

        assertEquals("14/1/2020" + "28/2/1200" + "28/2/1234" + "29/2/2000", date
                .runPatterns("14/1/2020 in da hause BC3234BM 28/2/1200 28/2/1234 29/2/2000 29/2/2001 drunk as dog"));
        assertEquals("29/2/33220", date.runPatterns("29/2/33220 riding"));
        assertEquals("11/11/2020" + "1/11/2020", date.runPatterns("11/11/2020 00/11/2020 1/11/2020 BC3234BM riding"));
    }

    @Test
    public void testScaner() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String textWithDate = new String(scanner.nextLine());
            System.out.println(date.runPatterns(textWithDate));
        }
        scanner.close();
    }

}
