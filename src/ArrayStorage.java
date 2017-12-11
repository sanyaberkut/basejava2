/**
 * Array based storage for Resumes
 */
import java.util.Arrays;
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int realSize = 0;

    void clear() {
        for(int i = 0; i<realSize; i++) {
            storage[i] = null;
        }
        realSize = 0;
    }

    void save(Resume r) {

        if( realSize < storage.length ) {
            storage[realSize] = r;
            realSize++;
        } else {
            System.out.println("Хранилище заполнено");
        }
    }

    Resume get(String uuid) {
        for(int i = 0; i<realSize; i++) {
            if (storage[i] != null && storage[i].toString().equals(uuid)) {
                    return storage[i];
            }
        }
        return null;
    }

    void delete(String uuid) {
        for(int i = 0; i<realSize; i++) {
            if (storage[i] != null && storage[i].toString().equals(uuid)) {
                storage[i] = null;
                // переносим в позицию где был удален элемент с послдеднего елемента масива
                storage[i]=storage[realSize-1];
                storage[realSize-1] = null;
                realSize--;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] storagesNew = new Resume[realSize];

        for(int i = 0; i<realSize; i++) {
                storagesNew[i] = storage[i];
        }
        return storagesNew;
    }

    int size() {
        int k = 0;
        for(int i = 0; i<storage.length; i++) {
            if( storage[i] != null ) {
                k++;
            }
        }
        realSize = k;
        return k;
    }
}
