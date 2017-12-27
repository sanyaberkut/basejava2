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
        if( get(r.getUuid()) == null) {
            System.out.println("Резюме не найдено с данным идентификатор");
        } else {
            int index = getStorageIndex(uuid);
            if(index>0) {
                storage[index] = r;
                System.out.println("Резюме обновлено");
            }
        }
    }

    public Resume get(String uuid) {
        for(int i = 0; i<size; i++) {
            if (storage[i] != null && storage[i].toString().equals(uuid)) {
                return storage[i];
            }
        }
        return null;
    }

    public int getStorageIndex(String uuid) {
        for(int i = 0; i<size; i++) {
            if (storage[i] != null && storage[i].toString().equals(uuid)) {
                return i;
            }
        }
        return 0;
    }


    public void delete(String uuid) {
        if( get(uuid) == null) {
            System.out.println("Резюме не найдено с данным идентификатор");
        } else {
            int index = getStorageIndex(uuid);
            if(index>0) {
                // переносим в позицию где был удален элемент с послдеднего елемента масива
                storage[index] = storage[size - 1];
                storage[size - 1] = null;
                size--;
                System.out.println("Резюме удалено");
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        Resume[] storagesNew = new Resume[size];
        System.arraycopy(storage, 0, storagesNew, 0, size);
        return storagesNew;
    }

    public int size() {
        return size;
    }
}
