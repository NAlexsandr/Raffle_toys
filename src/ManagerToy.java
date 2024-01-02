import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ManagerToy {
    private ArrayList<Toy> ListToysStore = new ArrayList<>();
    private ArrayList<Toy> ListPrizeToys = new ArrayList<>();

    public ArrayList<Toy> getListToysStore() {
        return ListToysStore;
    }

    public ArrayList<Toy> getListPrizeToys() {
        return ListPrizeToys;
    }

    public void CreateToy(String name, int id, double dropRate){
        Toy newToy = new Toy(name,id, dropRate);
        ListToysStore.add(newToy);
    }

    //Получаем призовую игрушку при розыгрыше по теории вероятности
    public Toy rafflePrizes(){
        double sum = 0;
        for (Toy toy: ListToysStore){
            sum = sum + toy.getDropRate();

        }
        System.out.println(sum + "\n");
        //sum = 10 * sum;
        //System.out.println(sum + "\n");
        Random rn = new Random();
        double randomNum = rn.nextDouble(0, sum);
        //randomNum = randomNum / 10;
        System.out.println(randomNum + "\n");
        sum = 0;
        for (Toy toy: ListToysStore){
            sum = sum + toy.getDropRate();
            if ((randomNum <= sum) & (randomNum > (sum - toy.getDropRate()))) {
                System.out.println(toy.getName() + "\n");
                return toy;
            }
        }
        Toy t = new Toy("0", 0, 0);
        return t;
    }

    //Получаем первую призовую игрушку списке ListPrizeToys и удаляем ее из списка
    public Toy GetPrize(){
        if (ListPrizeToys.size() == 0)
            System.out.println("Список пуст");
        else {
            Toy resultToy = ListPrizeToys.get(0);
            ListPrizeToys.remove(0);
            return resultToy;
        }
        return null;
    }

    //Меняет в списке у всех игрушек, с определенным наименованием, вес (частоту выпадения) игрушек
    public void ChangePersonalizedToyDropRate(String name, double newDropRate){
        for (Toy toy: ListToysStore){
            if (toy.getName().equals(name))
                toy.setDropRate(newDropRate);
        }
    }
    public String PrintListToysStore() {
        String resultString = "";
        for (Toy toy : ListToysStore) {
            resultString = resultString + toy.getName() + "  " + toy.getDropRate() + "\n";
        }
        return resultString;
    }

    public String PrintListPrizeToys() {
        String resultString = "";
        for (Toy toy : ListPrizeToys) {
            resultString = resultString + toy.getName() + "  " + toy.getDropRate() + "\n";
        }
        return resultString;
    }
}
