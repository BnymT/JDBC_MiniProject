import java.util.Scanner;

/*
Proje:Student Management System
     -1-Herhangi bir eğitim kurumu için öğrenci yönetim uygulaması geliştiriniz.
     -2-Kullanıcı
               -C:create:öğrenci kayıt
               -R:read:öğrenci veya öğrencileri görüntüleme
               -U:update: id ile öğrenci güncelleme
               -D:delete: id ile öğrenci silme
               -R: ad-soyad ile öğrenci filtreleme
       işlemlerini yapabilmeli.
     -3-öğrenci:id,name,lastname,city,age özelliklerine sahiptir.
     Ödev : Course Management System
 */
public class Runner {
    public static void main(String[] args) {


        //1-Uygulama islemleri icin menu olmali
        //2- Student class ini olustur
        start();
    }

    private static void start() {
        Scanner inp = new Scanner(System.in);

        StudentService service=new StudentService();
        service.createTable();
        int select;
        do {
            System.out.println("=========================================");
            System.out.println("Öğrenci Yönetim Paneli");
            System.out.println("1-Öğrenci Kayıt");
            System.out.println("2-Tüm Öğrencileri Listele");
            System.out.println("3-Öğrenci Güncelle");
            System.out.println("4-Öğrenci Sil");
            System.out.println("5-Öğrenci Bul");
            System.out.println("6-Ad veya Soyad ile Öğrenci Filtrele");
            System.out.println("0-Çıkış");
            System.out.println("İşlem seçiniz");
            select = inp.nextInt();
            inp.nextLine();
            int id;
            switch (select) {
                case 1 -> service.saveStudent(); //save
                case 2 -> service.getAllStudents(); //listele
                case 3 -> {
                    //Güncelle
                    id = getId(inp);
                    service.updateStudent(id);
                }
                case 4 -> {
                    //sil
                    id = getId(inp);
                    service.deleteStudent(id);
                }
                case 5 -> {
                    //öğrenci bul
                    id = getId(inp);
                    Student student = service.getStudentById(id);
                    if (student == null) {
                        System.out.println("Öğrenci bulunamadi");
                    } else {
                        System.out.println(student);
                    }
                }
                case 6 -> service.listStudentsByNameOrLastName(); //ad veya soyad arama
                case 0 -> System.out.println("İyi günler....");
                default -> System.out.println("Hatalı giriş !!!");
            }

        } while (select != 0);

    }
    private static int getId(Scanner inp){
        System.out.println("Öğrenci id : ");
        int id=inp.nextInt();
        inp.nextLine();
        return id;
    }
}