import com.example.decorator.SmartDocument;
import com.google.cloud.vision.v1.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class SmartDocumentTest {

    @Test
    void testSmartDocumentParse() throws Exception {
        TextAnnotation mockAnnotation = TextAnnotation.newBuilder().setText("Mocked text").build();
        AnnotateImageResponse mockResponse = AnnotateImageResponse.newBuilder()
                .setFullTextAnnotation(mockAnnotation)
                .build();

        BatchAnnotateImagesResponse mockBatchResponse = BatchAnnotateImagesResponse.newBuilder()
                .addAllResponses(Collections.singletonList(mockResponse))
                .build();

        ImageAnnotatorClient mockClient = mock(ImageAnnotatorClient.class);
        when(mockClient.batchAnnotateImages(anyList())).thenReturn(mockBatchResponse);

        try (var mockedStatic = Mockito.mockStatic(ImageAnnotatorClient.class)) {
            mockedStatic.when(ImageAnnotatorClient::create).thenReturn(mockClient);
            SmartDocument smartDocument = new SmartDocument("gs://mock-bucket/mock-image");
            String result = smartDocument.parse();
            assertEquals("Mocked text", result);
            verify(mockClient, times(1)).batchAnnotateImages(anyList());
        }
    }
}
