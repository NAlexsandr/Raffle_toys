import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        ManagerToy manager = new ManagerToy();
        manager.CreateToy("Мишка плюшевый", 1, 0.2);
        manager.CreateToy("Мишка плюшевый", 2, 0.2);
        manager.CreateToy("Автомобиль грузовой", 3, 0.3);
        manager.CreateToy("Пистолет водяной", 4, 0.4);
        manager.CreateToy("Пистолет водяной", 5, 0.4);
        manager.CreateToy("Кукла Барби", 6, 0.1);
        manager.CreateToy("Кукла Барби", 7, 0.1);
        manager.CreateToy("Железная дорога", 8, 0.5);
        manager.CreateToy("Железная дорога", 9, 0.5);
        manager.CreateToy("Дед Мороз заводной", 10, 0.7);

                             //Получаем призовую игрушку при розыгрыше по теории вероятности
        Toy prize = manager.rafflePrizes();
        //System.out.println(prize.getName());
                             //Записываем призовую игрушку в файл
        File file = new File("Prize_Toys.txt");
        if (!(file.exists())) {
            file.createNewFile();
        }
        try {
            FileWriter writer = new FileWriter("Prize_Toys.txt", true);
            writer.write(prize.getName());
            writer.write("\n");
            writer.close();

        } catch (IOException e) {
            System.out.println("Возникла ошибка во время записи, проверьте данные.");
        }
        System.out.println(manager.PrintListToysStore());
                              //Получаем первую призовую игрушку списке ListPrizeToys и удаляем ее из списка
        manager.GetPrize();

        //System.out.println(manager.getListPrizeToys());
                              // Меняем "вес" игрушке "Кукла Барби"
        manager.ChangePersonalizedToyDropRate("Кукла Барби", 0.7);
        //System.out.println(manager.getListToysStore().size());
        System.out.println(manager.PrintListToysStore());

    }
}