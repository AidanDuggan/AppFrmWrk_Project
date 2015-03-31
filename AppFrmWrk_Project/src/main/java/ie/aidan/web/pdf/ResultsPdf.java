package ie.aidan.web.pdf;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;

@Component("Results")
public class ResultsPdf extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model,
			Document document, PdfWriter writer, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		/*
		int numberofquestions = ;
		Table table = new Table(numberofquestions);
		table.addCell("Question");
		table.addCell("Answer Given");
		table.addCell("Correct Answer");

		List<Result> results = (List<Results>) model.get("results");
		for (Result result : results) {
			table.addCell(result.getQuestion());
			table.addCell(result.getAnswerGiven());
			table.addCell(result.getCorrectAnswer());
			table.addCell(todo.isCorrect() ? "yes" : "no");

		}
		document.add(new Paragraph("Results"));
		document.add(table);
		*/
		
	}
}
