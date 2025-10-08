import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import com.itextpdf.text.pdf.draw.LineSeparator;
import java.io.FileOutputStream;
import java.io.IOException;

public class ResumeGenerator {

    private static final String FULL_NAME = "Mehmet Akif Geriş";
    private static final String EMAIL = "mehmetakifgeris9@gmail.com";
    private static final String PHONE = "+90 543 210 98 76";
    private static final String ADDRESS = "İzmir, Türkiye";
    private static final String LINKEDIN = "linkedin.com/in/makifgeris";

    public static void main(String[] args) {
        try {
            // Sayfa ve kenar boşlukları
            Document document = new Document(PageSize.A4, 36, 36, 30, 30);
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("ozgecmis.pdf"));

            document.open();

            // Türkçe karakterler için Unicode font ayarı
            String fontPath = "DejaVuSans.ttf";
            BaseFont bf = BaseFont.createFont(fontPath, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);

            // Başlık + fotoğraf
            addHeaderWithPhoto(document, bf);

            // İş deneyimleri
            addWorkExperience(document, bf);

            // Eğitim bilgileri
            addEducation(document, bf);

            // Yetenekler
            addSkills(document, bf);

            document.close();
            writer.close();

            System.out.println("Özgeçmiş başarıyla oluşturuldu: ozgecmis.pdf");

        } catch (Exception e) {
            System.err.println("Hata oluştu: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Fotoğraf (sol) ve başlık bilgileri (sağ)
     */
    private static void addHeaderWithPhoto(Document document, BaseFont bf) throws DocumentException, IOException {
        PdfPTable headerTable = new PdfPTable(2);
        headerTable.setWidthPercentage(100);
        headerTable.setWidths(new float[]{1, 3});

        // Sol hücre - Fotoğraf
        PdfPCell photoCell = new PdfPCell();
        photoCell.setBorder(Rectangle.NO_BORDER);
        photoCell.setVerticalAlignment(Element.ALIGN_TOP);
        photoCell.setPaddingRight(15);

        try {
            Image photo = Image.getInstance("photo.jpg");
            photo.scaleToFit(100, 130);
            photoCell.addElement(photo);
        } catch (Exception e) {
            Font noteFont = new Font(bf, 8, Font.ITALIC, BaseColor.GRAY);
            Paragraph note = new Paragraph("[Fotoğraf bulunamadı]", noteFont);
            photoCell.addElement(note);
        }

        headerTable.addCell(photoCell);

        // Sağ hücre - Bilgiler
        PdfPCell infoCell = new PdfPCell();
        infoCell.setBorder(Rectangle.NO_BORDER);
        infoCell.setVerticalAlignment(Element.ALIGN_MIDDLE);

        Font titleFont = new Font(bf, 22, Font.BOLD, BaseColor.DARK_GRAY);
        Font subtitleFont = new Font(bf, 12, Font.NORMAL, BaseColor.GRAY);
        Font contactFont = new Font(bf, 9, Font.NORMAL);

        Paragraph title = new Paragraph(FULL_NAME, titleFont);
        title.setSpacingAfter(3);
        infoCell.addElement(title);

        Paragraph subtitle = new Paragraph("Yazılım Mühendisliği Öğrencisi", subtitleFont);
        subtitle.setSpacingAfter(8);
        infoCell.addElement(subtitle);

        infoCell.addElement(new Paragraph("E-posta: " + EMAIL, contactFont));
        infoCell.addElement(new Paragraph("Telefon: " + PHONE, contactFont));
        infoCell.addElement(new Paragraph("Adres: " + ADDRESS, contactFont));
        infoCell.addElement(new Paragraph("LinkedIn: " + LINKEDIN, contactFont));

        headerTable.addCell(infoCell);
        headerTable.setSpacingAfter(12);
        document.add(headerTable);
    }

    /**
     * İş deneyimleri
     */
    private static void addWorkExperience(Document document, BaseFont bf) throws DocumentException {
        addSectionTitle(document, "İŞ DENEYİMLERİ", bf);

        addJobExperience(document,
                bf,
                "Denetim Kurulu Üyesi",
                "Siber Güvenlik Kulübü",
                "Eylül 2024 - Haziran 2025",
                "\u2022 Java ve Spring Boot ile kurumsal uygulamalar geliştirme\n" +
                        "\u2022 Takım liderliği ve kod inceleme süreçleri"
        );

        addJobExperience(document,
                bf,
                "Backend Developer Stajyeri",
                "TechNova Yazılım",
                "Temmuz 2024 - Eylül 2024",
                "\u2022 RESTful API geliştirme ve MySQL veritabanı entegrasyonu\n" +
                        "\u2022 Spring Framework ve Hibernate kullanımı"
        );

        addJobExperience(document,
                bf,
                "Freelance Web Geliştirici",
                "Serbest Çalışma",
                "2023 - Devam ediyor",
                "\u2022 HTML, CSS, JavaScript ve React ile web arayüzleri tasarımı\n" +
                        "\u2022 Müşteri taleplerine özel web sitesi çözümleri geliştirme"
        );
    }

    /**
     * Tek bir iş deneyimi kaydı
     */
    private static void addJobExperience(Document document, BaseFont bf,
                                         String position, String company, String period, String description)
            throws DocumentException {
        Font positionFont = new Font(bf, 11, Font.BOLD);
        Font companyFont = new Font(bf, 10, Font.ITALIC);
        Font periodFont = new Font(bf, 9, Font.NORMAL, BaseColor.GRAY);
        Font descFont = new Font(bf, 9, Font.NORMAL);

        Paragraph positionPara = new Paragraph(position, positionFont);
        positionPara.setSpacingBefore(2);
        document.add(positionPara);

        document.add(new Paragraph(company, companyFont));
        document.add(new Paragraph(period, periodFont));

        Paragraph descPara = new Paragraph(description, descFont);
        descPara.setSpacingAfter(5);
        document.add(descPara);
    }

    /**
     * Eğitim bilgileri
     */
    private static void addEducation(Document document, BaseFont bf) throws DocumentException {
        addSectionTitle(document, "EĞİTİM", bf);

        Font degreeFont = new Font(bf, 11, Font.BOLD);
        Font schoolFont = new Font(bf, 10, Font.NORMAL);
        Font yearFont = new Font(bf, 9, Font.NORMAL, BaseColor.GRAY);

        Paragraph degreePara = new Paragraph("Yazılım Mühendisliği, Lisans", degreeFont);
        degreePara.setSpacingBefore(2);
        document.add(degreePara);

        document.add(new Paragraph("Kırklareli Üniversitesi", schoolFont));
        Paragraph year = new Paragraph("2024 - 2028", yearFont);
        year.setSpacingAfter(5);
        document.add(year);
    }

    /**
     * Yetenekler
     */
    private static void addSkills(Document document, BaseFont bf) throws DocumentException {
        addSectionTitle(document, "YETENEKLER", bf);

        Font skillFont = new Font(bf, 10, Font.NORMAL);

        Paragraph skill1 = new Paragraph("\u2022 Temel proje yönetimi ve ekip çalışması", skillFont);
        skill1.setSpacingBefore(2);
        document.add(skill1);

        document.add(new Paragraph("\u2022 Problem çözme ve analitik düşünme yeteneği", skillFont));
        document.add(new Paragraph("\u2022 Java, Spring Boot, HTML, CSS, JavaScript bilgisi", skillFont));
        document.add(new Paragraph("\u2022 MySQL ve Git/GitHub kullanımı", skillFont));
    }

    /**
     * Bölüm başlığı
     */
    private static void addSectionTitle(Document document, String title, BaseFont bf) throws DocumentException {
        Font sectionFont = new Font(bf, 13, Font.BOLD, BaseColor.BLACK);
        Paragraph section = new Paragraph(title, sectionFont);
        section.setSpacingBefore(10);
        section.setSpacingAfter(5);

        LineSeparator line = new LineSeparator();
        line.setLineColor(BaseColor.DARK_GRAY);

        document.add(section);
        document.add(new Chunk(line));
        document.add(new Paragraph(" "));
    }
}
