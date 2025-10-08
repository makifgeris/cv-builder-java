# Özgeçmiş (CV) Oluşturucu

Bu proje, **Java** ve **iText PDF kütüphanesi** kullanılarak özgeçmiş (CV) oluşturmayı sağlayan basit bir uygulamadır.  
Kullanıcı bilgileri, iş deneyimleri, eğitim geçmişi ve yetenekler PDF dosyası olarak üretilir. Ayrıca fotoğraf desteği de bulunmaktadır.

##  Özellikler
- PDF formatında profesyonel görünümlü özgeçmiş üretir  
- Türkçe karakter desteği (Unicode font kullanımı)  
- Kişisel bilgiler (isim, e-posta, telefon, adres, LinkedIn)  
- İş deneyimleri bölümü  
- Eğitim bilgileri bölümü  
- Yetenekler bölümü  
- Fotoğraf ekleme desteği (isteğe bağlı)  

<pre> ##  Proje Dosyaları   
   ├── ResumeGenerator.java # Ana Java kaynağı 
   ├── ResumeGenerator.class # Derlenmiş sınıf 
   ├── itextpdf-5.5.13.3.jar # iText PDF kütüphanesi 
   ├── DejaVuSans.ttf # Türkçe karakter desteği için font
   ├── calistir.bat # Programı kolayca çalıştırmak için betik dosyası
   ├── photo.jpg # Profil fotoğrafı (opsiyonel) 
   └── ozgecmis.pdf # Üretilen çıktı  </pre>

##  Çalıştırma Adımları

1. Bilgisayarınızda **Java JDK 8+** kurulu olduğundan emin olun.
2. iText PDF kütüphanesi (örnek: itextpdf-5.5.13.3.jar) proje dosyalarıyla aynı dosyada olduğundan emin olun. 
3. Proje dosyalarını aynı klasöre yerleştirin.  
4. Programı çalıştırmanın iki yolu vardır:

##  Fotoğraf Ekleme

Program, bulunduğu dizinde photo.jpg isimli bir dosya arar.

Eğer bulunmazsa, [Fotoğraf bulunamadı] notu eklenir.

Kendi fotoğrafınızı eklemek için aynı klasöre photo.jpg koyabilirsiniz.


##  Çalıştırma: `calistir.bat` Dosyası ile (Windows)
Klasördeki `calistir.bat` dosyasına çift tıklayın.

## Alternatif Çalıştırma
1. Bilgisayarınızda **Java JDK** kurulu olduğundan emin olun.  
2. Projeyi derleyin:  
   ```bash
   javac -cp itextpdf-5.5.13.3.jar ResumeGenerator.java
3. Projeyi çalıştırın:
   ```bash
   java -cp .;itextpdf-5.5.13.3.jar ResumeGenerator
 Çalıştırma tamamlandığında bulunduğunuz dizine ozgecmis.pdf adlı dosya oluşturulur.

