# Projenin Özeti
Uygulama bir e-ticaret uygulamasıdır. Bu uygulama `Firebase` veritabanına eklemek istediğimiz ürünlerin başlığını, açıklamasını, yılını, fiyatını ve kategorisini girdiğimiz
ürünlerin veri tabanına eklenip daha sonra listelemek için veritabanından çekilmesi şeklinde çalışmaktadır.
Açılan ilk sayfada ürün bilgilerini girip kategorisini seçtikten sonra ekle butonuna basıldığında ürün bilgileri `Firebase  realtime`
veritabanına kayıt oluyor. Liste butonuna basıldığında ise kategori sayfası açılıyor. Bu sayfada hangi kategoriye gitmek istediğimizi seçiyoruz. Kategorimizi seçtikten sonra 
seçilen kategorideki ürünlerimizin bulunduğu sayfa açılıyor. Eğer ürünlerimizin detaylarını görmek istersek ürünlere tıkladığımız zaman detay sayfamız açılıyor ve ürünlerimizin
detaylarını görmüş oluyoruz.
<br> 
# Projenin Tasarımı
Proje 4 sayfadan oluşuyor. Veritabanında "Urun" ve "kategori" adında 2 adet tablo bulunmaktadır. Listeye basıldığında ürünleri kategorilere göre listelemek için bir kategori
sayfası oluşturdum. Bu kategori sayfasının cardview tasarım layoutunu oluşturdum.Daha sonra bir sınıf modülü(kategori adapter) oluşturup cardview layoutunu bu adapter içinde
extend ederek bu adapter'a bağladım. Kategori verilerini burada alarak gerekli kodları(cardview tıklanma, bağlama) burada yazıp bu adapterı "KategoriActivity" sınıfına bağladım. 
KategoriActivity sınıfında veriler alt alta olsun diye "LinearLayoutManager" olarak ayarladım. Bu kategorilere tıklanınca kategori nesnesini ürünler sayfasına yollayabilmek için
`Serializable` özelliğini kategori sınıfında ve ürün sınıfında implements ettim çünkü ürün nesnelerinide detay sayfasına yolladım. Ürünler sayfasını aynı kategori sayfası gibi
cartview layoutunu ve ürünler adapterını oluşturup kategori adaptera göre sorgu yapıp aynı kategorideki ürünleri getirdim fakat burada StaggeredGridLayoutManager kullanarak
ürünleri tek satırda 2 şer tane olacak şekilde tasarladım. Son olarakta detay sayfasına ürünlerin verilerini(nesneleri) yollayıp, veritabanından aldığım verilerin görüntülenmesini sağladım. 
<br><br>
### Projedeki Ek Özellikler
Açılan ilk sayfada `databinding` ile tasarımsal kodları modern hale getirdim. Görsel nesnelere pratik bir şekilde erişmeyi sağladım. <br>
Açılan ilk sayfada Radiobutonların tıklanılma kodlarını tasarım bölümüne yazıp daha okunaklı hale getirdim.

