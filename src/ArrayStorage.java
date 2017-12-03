/**
 * Array based storage for Resumes
 */
import java.util.Arrays;
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
        for(int i = 0; i<storage.length; i++) {
            storage[i] = null;
        }
    }

    void save(Resume r) {
        // изначально ищем есть ли в масиве пустой элемент и пытаемся туда добавить новый элемент
        for(int i = 0; i<storage.length; i++) {
            if( storage[i] == null ) {
                storage[i] = r;
                return;
            }
        }
        // если масив был заполнен полностью, нам нужно создать масив на единицу больше
        // переменная с новой размерностью масива
        int j = storage.length+1;

        // создаем новый масив на основаниеи старого с размерностью на 1 больше
        Resume[] arr2 = Arrays.copyOf(storage, j);
        arr2[j-1] = r;
        // заменяем изначальный масив на новый изменённый
        storage = arr2;
    }

    Resume get(String uuid) {
        for(int i = 0; i<storage.length; i++) {
            if (storage[i] != null) {
                if (storage[i].toString().equals(uuid)) {
                    return storage[i];
                }
            }
        }
        return null;
    }

    void delete(String uuid) {
        for(int i = 0; i<storage.length; i++) {
            if (storage[i] != null) {
                if (storage[i].toString().equals(uuid)) {
                    storage[i] = null;
                }
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {

        int k = 0;
        for(int i = 0; i<storage.length; i++) {
            if ( storage[i] == null ) {
                k++;
            }
        }

        Resume[] storagesNew = new Resume[storage.length - k];

        int j = 0;
        for(int i = 0; i<storage.length; i++) {
            if ( storage[i] != null ) {
                storagesNew[j] = storage[i];
                j++;
            }
        }
        storage = storagesNew;
        return storage;
    }

    int size() {
        int k = 0;
        for(int i = 0; i<storage.length; i++) {
            if( storage[i] != null ) {
                k++;
            }
        }
        return k;
    }
}
