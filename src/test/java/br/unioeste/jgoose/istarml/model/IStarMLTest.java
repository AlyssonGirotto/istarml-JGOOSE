package br.unioeste.jgoose.istarml.model;

import br.unioeste.jgoose.istarml.ActorTag;
import br.unioeste.jgoose.istarml.DiagramTag;
import br.unioeste.jgoose.istarml.IStarMLTag;
import java.io.StringReader;
import javax.xml.bind.JAXB;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import org.xml.sax.SAXParseException;

/**
 *
 * @author Leonardo Merlin - leonardo.merlin at unioeste.br
 */
//@RunWith(Parameterized.class)
public class IStarMLTest {

    private Marshaller jaxbMarshaller;
    private Unmarshaller jaxbUnmarshaller;
    private StringReader xml;
    private Boolean expectedValidation;
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    public IStarMLTest(String xml, Boolean expectedValidation) {
        this.xml = new StringReader(xml);
        this.expectedValidation = expectedValidation;
    }

//    @Parameterized.Parameters
//    public static Collection params() throws ParserConfigurationException, TransformerConfigurationException, TransformerException {
//        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
//        Document doc = builder.newDocument();
//        doc.setXmlStandalone(true);
//        
//        Transformer transformer = TransformerFactory.newInstance().newTransformer();
//        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
//        
//        StringWriter buffer = new StringWriter();
//        transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
//        
//        Element istarmlTag = doc.createElement("istarml");
//        Element diagramTag = doc.createElement("diagram");
//        istarmlTag.appendChild(diagramTag);
//        doc.appendChild(istarmlTag);
//        
//        DOMSource dom = new DOMSource(doc);
//        transformer.transform(dom, new StreamResult(buffer));
//        String str = buffer.toString();
//        System.out.println("element:" + str);
//        
//        List<Object> parameters = new ArrayList<>();
//        
////        System.out.println("element output" + element.toString());
//        return Arrays.asList(new Object[][] {
//                { "<istarml VERSION=\"1.0\"/>", false }, // invalid
////                { "<?xml VERSION=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><istarml VERSION=\"1.0\"/>", true }, // invalid
////                { "<istarml VERSION=\"1.0\"><istarml>", false }, // invalid
////                { "<istarml VERSION=\"1.0\"></istarml>", false }, // invalid
////                { "<istarml VERSION=\"1.0\"><diagram/></istarml>", false }, // invalid
////                { "<istarml VERSION=\"1.0\"><diagram></diagram></istarml>", false }, // invalid
////                { "<istarml VERSION=\"1.0\"><diagram id=\"asdf\"></diagram></istarml>", true }, // invalid
////                { "", false }
////                { "", true },
////                { "", false }
//        });
//    }
    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws JAXBException {
        // For XML annotation
        JAXBContext jaxbContext = JAXBContext.newInstance(IStarMLTag.class, DiagramTag.class, ActorTag.class);
        this.jaxbMarshaller = jaxbContext.createMarshaller();
        this.jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        // output pretty printed
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);


    }

    @After
    public void tearDown() {
    }

//    @Test
    public void testUnmarshall() {
        if (!this.expectedValidation) {
            thrown.expect(SAXParseException.class);
        }
        IStarMLTag istarml = JAXB.unmarshal(this.xml, IStarMLTag.class);
    }
//    http://www.vogella.com/articles/JUnit/article.html#usingjunit_annotations
//    @Ignore("Not implemented yet")
//    @Test
//    public void importCorrectFile() {
//        
//    }
//    
//    @Ignore("Not implemented yet")
//    @Test(timeout = 500)
//    public void checkPerformance() {
////        Fails, if the method takes longer than 500 milliseconds.
//    }
//    
//    @Ignore("Not implemented yet")
//    @Test(expected = NullPointerException.class)
//    public void importIncorrectFile(){
////        Fails, if the method does not throw the named exception.
//        throw new NullPointerException("todo");
//    }
}