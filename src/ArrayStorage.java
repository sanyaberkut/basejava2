/**
 * Array based storage for Resumes
 */
import java.util.Arrays;
public class ArrayStorage {
    private Resume[] storage = new Resume[10000];
    private int size = 0;

    public void clear() {
        for(int i = 0; i<size; i++) {
            storage[i] = null;
        }
        size = 0;
    }

    public void save(Resume r) {

        if(get(r.getUuid()) == null) {
            if( size < storage.length ) {
                storage[size] = r;
                size++;
                System.out.println("Добавлен новый элемент");
            } else {
                System.out.println("Хранилище заполнено");
            }
        } else {
            System.out.println("Такой элемент уже существует");
        }
    }

    public void update(String uuid, Resume r) {
        int i = getStorageIndex(uuid);
        if(i != -1) {
            storage[i] = r;
            System.out.println("Резюме обновлено");
        } else {
            System.out.println("Резюме не найдено с данным идентификатор");
        }
    }

    public Resume get(String uuid) {
        int i = getStorageIndex(uuid);
        if(i != -1) {
            return storage[i];
        } else {
            return null;
        }
    }

    public int getStorageIndex(String uuid) {
        for(int i = 0; i<size; i++) {
            if (storage[i] != null && storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }


    public void delete(String uuid) {
        int i = getStorageIndex(uuid);
        if(i != -1) {
            // переносим в позицию где был удален элемент с послдеднего елемента масива
            storage[i] = storage[size - 1];
            storage[size - 1] = null;
            size--;
            System.out.println("Резюме удалено");
        } else {
            System.out.println("Резюме не найдено с данным идентификатор");
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    public int size() {
        return size;
    }
}
