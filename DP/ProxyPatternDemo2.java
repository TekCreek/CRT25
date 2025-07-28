import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Proxy Pattern -
 *
 * Use the proxy pattern to create a representative object that controls
 * access to another object.
 *
 * Types -
 *
 * Remote Proxy - For accessing a remote object.
 * Virtual Proxy - For deferred initialization
 * Protection proxy - for secured and controlled access to the object.
 */

interface Dict {
    Optional<String> getMeaning(String word);
    void modify(String word, String meaning);
}

class DictImpl implements Dict {

    private Map<String, String> dict = new HashMap<>();

    @Override
    public Optional<String> getMeaning(String word) {
        String meaning = dict.get(word);
        if (meaning == null) {
            return Optional.empty();
        } else {
            return Optional.of(meaning);
        }
    }

    @Override
    public void modify(String word, String meaning) {
        dict.put(word, meaning);
    }
}

class VirutalProxyDictImpl implements Dict {

    // lazy initialization
    private Dict dict = null;

    private Dict getDictionary() {
        if (dict == null) {
            System.out.println("Dictionary object created");
            dict = new DictImpl();
        }
        return dict;
    }

    @Override
    public Optional<String> getMeaning(String word) {
        return getDictionary().getMeaning(word);
    }

    @Override
    public void modify(String word, String meaning) {
        getDictionary().modify(word, meaning);
    }
}


// protection proxy
class ReadOnlyDictionary implements Dict {

    private Dict dict = new DictImpl();

    @Override
    public Optional<String> getMeaning(String word) {
        return dict.getMeaning(word);
    }

    @Override
    public void modify(String word, String meaning) {
        throw new UnsupportedOperationException("you can not modify");
    }
}

public class ProxyPatternDemo2 {
    public static void main(String[] args) {
        Dict dict = new VirutalProxyDictImpl();
        dict.modify("some", "some meaning");

        Dict dict1 = new ReadOnlyDictionary();
        dict1.modify("some", "some meaning");

    }
}
