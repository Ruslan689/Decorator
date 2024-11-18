import org.junit.jupiter.api.Test;
import com.example.decorator.Document;
import com.example.decorator.TimedDocument;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
public class TimedDocumentTest {
    @Test
    void testTimedDocumentParse() {
        Document mockDocument = mock(Document.class);
        when(mockDocument.parse()).thenReturn("Parsed content");

        TimedDocument timedDocument = new TimedDocument(mockDocument);
        String result = timedDocument.parse();

        assertEquals("Parsed content", result);

        verify(mockDocument, times(1)).parse();
    }
}
