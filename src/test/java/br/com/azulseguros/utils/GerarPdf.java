package br.com.azulseguros.utils;

import java.awt.Color;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.Image;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class GerarPdf {

    public void criarPdf(Scenario scenario, WebDriver driver, List<File> screenshots, List<String> printDescriptions) {
        try {
            Document document = new Document();
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            String currentDate = dateFormat.format(new Date());
            String osUsed = System.getProperty("os.name");
            String browserUsed = ((RemoteWebDriver) driver).getCapabilities().getBrowserName();
            String browserVersionUsed = ((RemoteWebDriver) driver).getCapabilities().getBrowserVersion();
            String filePath = System.getProperty("user.dir")
                    + File.separator
                    + "target"
                    + File.separator
                    + "reports"
                    + File.separator
                    + scenario.getName()
                    + "_"
                    + scenario.getId()
                    + ".pdf";

            createFilePath(filePath);

            PdfWriter.getInstance(document, new FileOutputStream(filePath));

            document.open();

            PdfPTable infoTable = new PdfPTable(2); // Tabela com 2 colunas
            infoTable.setWidthPercentage(100);

            infoTable.addCell(createInfoCell("Nome do Caso de Teste", true)); // Adiciona negrito
            infoTable.addCell(createInfoCell(scenario.getName(), false)); // Não é negrito
            infoTable.addCell(createInfoCell("Data e Hora da Execução", true)); // Adiciona negrito
            infoTable.addCell(createInfoCell(currentDate, false)); // Não é negrito
            infoTable.addCell(createInfoCell("Sistema Operacional Utilizado", true)); // Adiciona negrito
            infoTable.addCell(createInfoCell(osUsed, false)); // Não é negrito
            infoTable.addCell(createInfoCell("Navegador Utilizado", true)); // Adiciona negrito
            infoTable.addCell(createInfoCell(browserUsed
                    + " v. "
                    + browserVersionUsed, false)); // Não é negrito
            infoTable.addCell(createInfoCell("Status do Teste", true)); // Adiciona negrito
            infoTable.addCell(createInfoCell(scenario.isFailed() ? "Falhou" : "Passou", false, scenario.isFailed())); // Adiciona negrito e define a
                                                                                                                      // cor da fonte

            document.add(infoTable);
            document.add(new Paragraph("\n"));

            // Adiciona os prints ao PDF
            for (int i = 0; i < screenshots.size(); i++) {

                // Adiciona a imagem ao PDF

                Image image = Image.getInstance(FileUtils.readFileToByteArray(screenshots.get(i)));

                // Redimensiona a imagem para caber na página, mantendo a proporção
                float documentWidth = document.getPageSize().getWidth() - document.leftMargin() - document.rightMargin();
                float documentHeight = document.getPageSize().getHeight() - document.topMargin() - document.bottomMargin();
                image.scaleToFit(documentWidth, documentHeight);

                PdfPTable table = new PdfPTable(1);
                // Adiciona a descrição da imagem à célula da tabela
                PdfPCell descriptionCell = new PdfPCell(new Paragraph(i
                        + 1
                        + ". "
                        + printDescriptions.get(i)));
                descriptionCell.setBorderWidth(0);
                table.addCell(descriptionCell);

                // Adiciona a imagem ao documento dentro de uma célula de tabela
                PdfPCell cell = new PdfPCell(image, true);
                cell.setBorder(PdfPCell.NO_BORDER);
                table.addCell(cell);
                document.add(table);

                document.add(new Paragraph("\n"));
            }

            // Fecha o documento
            document.close();
        } catch (DocumentException | IOException e) {
            e.printStackTrace();
        }
    }

    private PdfPCell createInfoCell(String text, boolean bold, boolean failed) {
        Font font;
        if (failed) {
            font = new Font(Font.HELVETICA, 12, Font.BOLD, Color.RED);
        } else {
            font = new Font(Font.HELVETICA, 12, Font.BOLD, Color.GREEN);
        }
        PdfPCell cell = new PdfPCell(new Paragraph(text, font));
        // cell.setBorder(PdfPCell.NO_BORDER);
        cell.setBorderWidth(1);
        return cell;
    }

    private PdfPCell createInfoCell(String text, boolean bold) {
        PdfPCell cell = new PdfPCell(new Paragraph(text, bold ? new Font(Font.HELVETICA, 12, Font.BOLD) : new Font(Font.HELVETICA, 12)));
        cell.setBorderWidth(1);
        return cell;
    }

    private static void createFilePath(String filePath) {
        File file = new File(filePath);
        File parentDir = file.getParentFile();
        if (!parentDir.exists()) {
            boolean success = parentDir.mkdirs();
            if (!success) {
                throw new RuntimeException("Falha ao criar o caminho do arquivo.");
            }
        }
    }

}


