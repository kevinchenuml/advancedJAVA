package edu.KevinChen.advancedjava.assignment7.app;

import edu.KevinChen.advancedjava.assignment7.xml.Stocks;
import edu.KevinChen.advancedjava.assignment7.xml.Stock;
import edu.KevinChen.advancedjava.assignment7.model.StockQuote;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * A basic app that shows how to marshall and unmarshal XML instances.
 */
public class StockJAXB {

    private static String xmlInstance ="<stocks>\n" +
            "        <stock> symbol=\"VNET\" price=\"110.10\" time=\"2015-02-10 00:00:01\"></stock>\n" +
            "        <stock>> symbol=\"AGTK\" price=\"120.10\" time=\"2015-02-10 00:00:01\"></stock>\n" +
            "        <stock>> symbol=\"AKAM\" price=\"3.10\" time=\"2015-02-10 00:00:01\"></stock>\n" +
            "        <stock> symbol=\"AOL\"  price=\"30.10\" time=\"2015-02-10 00:00:01\"></stock>\n" +
            "        <stock> symbol=\"BCOM\" price=\"10.10\" time=\"2015-02-10 00:00:01\"></stock>\n" +
            "        <stock> symbol=\"BIDU\" price=\"10.10\" time=\"2015-02-10 00:00:01\"></stock>\n" +
            "        <stock> symbol=\"BCOR\" price=\"12.10\" time=\"2015-02-10 00:00:01\"></stock>\n" +
            "        <stock> symbol=\"WIFI\" price=\"16.10\" time=\"2015-02-10 00:00:01\"></stock>\n" +
            "        <stock> symbol=\"BRNW\" price=\"0.70\" time=\"2015-02-10 00:00:01\"></stock>\n" +
            "        <stock> symbol=\"CARB\" price=\"9.80\" time=\"2015-02-10 00:00:01\"></stock>\n" +
            "        <stock> symbol=\"JRJC\" price=\"111.11\" time=\"2015-02-10 00:00:01\"></stock>\n" +
            "        <stock> symbol=\"CCIH\" price=\"22.20\" time=\"2015-02-10 00:00:01\"></stock>\n" +
            "        <stock> symbol=\"CHIC\" price=\"4.30\" time=\"2015-02-10 00:00:01\"></stock>\n" +
            "        <stock> symbol=\"CNV\"  price=\"13.43\" time=\"2015-02-10 00:00:01\"></stock>\n" +
            "        <stock> symbol=\"CCOI\" price=\"1.10\" time=\"2015-02-10 00:00:01\"></stock>\n" +
            "        <stock> symbol=\"CNCG\" price=\".10\" time=\"2015-02-10 00:00:01\"></stock>\n" +
            "        <stock> symbol=\"CXDO\" price=\"90.00\" time=\"2015-02-10 00:00:01\"></stock>\n" +
            "        <stock> symbol=\"CRWG\" price=\"52.99\" time=\"2015-02-10 00:00:01\"></stock>\n" +
            "        <stock> symbol=\"ELNK\" price=\"45.40\" time=\"2015-02-10 00:00:01\"></stock>\n" +
            "        <stock> symbol=\"EATR\" price=\"15.60\" time=\"2015-02-10 00:00:01\"></stock>\n" +
            "        <stock> symbol=\"EDXC\" price=\"18.40\" time=\"2015-02-10 00:00:01\"></stock>\n" +
            "        <stock> symbol=\"ENV\"  price=\"220.61\" time=\"2015-02-10 00:00:01\"></stock>\n" +
            "        <stock> symbol=\"EPAZ\" price=\"101.11\" time=\"2015-02-10 00:00:01\"></stock>\n" +
            "        <stock> symbol=\"FB\"   price=\"500.17\" time=\"2015-02-10 00:00:01\"></stock>\n" +
            "        <stock> symbol=\"FDIT\" price=\"160.90\" time=\"2015-02-10 00:00:01\"></stock>\n" +
            "        <stock> symbol=\"FLPC\" price=\"177.70\" time=\"2015-02-10 00:00:01\"></stock>\n" +
            "        <stock> symbol=\"GCLT\" price=\"8.90\" time=\"2015-02-10 00:00:01\"></stock>\n" +
            "        <stock> symbol=\"GOOG\" price=\"700.10\" time=\"2015-02-10 00:00:01\"></stock>\n" +
            "        <stock> symbol=\"GOOG\" price=\".10\" time=\"2015-02-10 00:00:01\"></stock>\n" +
            "        <stock> symbol=\"GREZ\" price=\"77.91\" time=\"2015-02-10 00:00:01\"></stock>\n" +
            "        <stock> symbol=\"IACI\" price=\"40.52\" time=\"2015-02-10 00:00:01\"></stock>\n" +
            "        <stock> symbol=\"ICOA\" price=\"48.30\" time=\"2015-02-10 00:00:01\"></stock>\n" +
            "        <stock> symbol=\"IIJI\" price=\"32.80\" time=\"2015-02-10 00:00:01\"></stock>\n" +
            "        <stock> symbol=\"ILIA\" price=\"188.22\" time=\"2015-02-10 00:00:01\"></stock>\n" +
            "        <stock> symbol=\"INAP\" price=\"2.12\" time=\"2015-02-10 00:00:01\"></stock>\n" +
            "        <stock> symbol=\"IPAS\" price=\"1.02\" time=\"2015-02-10 00:00:01\"></stock>\n" +
            "        <stock> symbol=\"JCOM\" price=\"19.99\" time=\"2015-02-10 00:00:01\"></stock>\n" +
            "        <stock> symbol=\"LOGL\" price=\"18.21\" time=\"2015-02-10 00:00:01\"></stock>\n" +
            "        <stock> symbol=\"LLNW\" price=\"45.55\" time=\"2015-02-10 00:00:01\"></stock>\n" +
            "        <stock> symbol=\"LOOK\" price=\"38.90\" time=\"2015-02-10 00:00:01\"></stock>\n" +
            "        <stock> symbol=\"MEET\" price=\"21.27\" time=\"2015-02-10 00:00:01\"></stock>\n" +
            "        <stock> symbol=\"MEET\" price=\"310.31\" time=\"2015-02-10 00:00:01\"></stock>\n" +
            "        <stock> symbol=\"VOIS\" price=\"440.51\" time=\"2015-02-10 00:00:01\"></stock>\n" +
            "        <stock> symbol=\"MOMO\" price=\"8.51\" time=\"2015-02-10 00:00:01\"></stock>\n" +
            "        <stock> symbol=\"NETE\" price=\"13.16\" time=\"2015-02-10 00:00:01\"></stock>\n" +
            "        <stock> symbol=\"NTES\" price=\"14.23\" time=\"2015-02-10 00:00:01\"></stock>\n" +
            "        <stock> symbol=\"EGOV\" price=\"17.35\" time=\"2015-02-10 00:00:01\"></stock>\n" +
            "        <stock> symbol=\"NQ\" price=\"110.77\" time=\"2015-02-10 00:00:01\"></stock>\n" +
            "        <stock> symbol=\"OTOW\" price=\"60.41\" time=\"2015-02-10 00:00:01\"/></stock>n" +
            "</stocks>";


    public static void main(String[] args) throws JAXBException {

        // here is how to go from XML to Java
        JAXBContext jaxbContext = JAXBContext.newInstance(Stocks.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        Stocks stocks = (Stocks) unmarshaller.unmarshal(new StringReader(xmlInstance));
        System.out.println(stocks.toString());

        // here is how to go from Java to XML
        JAXBContext context = JAXBContext.newInstance(Stocks.class);
        Marshaller marshaller = context.createMarshaller();
        //for pretty-print XML in JAXB
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(stocks, System.out);

        //Write data to ORM Objects
        StockQuote stockQuote = new StockQuote();
        stockQuote.setPrice(stocks.getStock().get(1).getPrice());
        stockQuote.setSymbol(stocks.getStock().get(1).getSymbol());
        // Convert string time to
        Timestamp timestamp = null;
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
            Date parsedDate = dateFormat.parse(stocks.getStock().get(1).getTime());
            timestamp = new java.sql.Timestamp(parsedDate.getTime());
        } catch(Exception e) {}

        stockQuote.setTime(timestamp);

    }
}
