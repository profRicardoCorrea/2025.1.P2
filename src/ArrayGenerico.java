public class ArrayGenerico<T> {
    private T[] elementos;
    private int tamanho;
    private static final int CAPACIDADE_INICIAL = 10;

    @SuppressWarnings("unchecked")
    public ArrayGenerico() {
        // Não é possível criar um array de tipo genérico diretamente em Java
        // então fazemos um cast do Object[] para T[]
        this.elementos = (T[]) new Object[CAPACIDADE_INICIAL];
        this.tamanho = 0;
    }

    public void adicionar(T elemento) {
        if (tamanho == elementos.length) {
            aumentarCapacidade();
        }
        elementos[tamanho++] = elemento;
    }

    public T obter(int indice) {
        if (indice < 0 || indice >= tamanho) {
            throw new IndexOutOfBoundsException("Índice inválido");
        }
        return elementos[indice];
    }

    public void remover(int indice) {
        if (indice < 0 || indice >= tamanho) {
            throw new IndexOutOfBoundsException("Índice inválido");
        }
        for (int i = indice; i < tamanho - 1; i++) {
            elementos[i] = elementos[i + 1];
        }
        elementos[--tamanho] = null;
    }

    public int tamanho() {
        return tamanho;
    }

    @SuppressWarnings("unchecked")
    private void aumentarCapacidade() {
        T[] novoArray = (T[]) new Object[elementos.length * 2];
        System.arraycopy(elementos, 0, novoArray, 0, elementos.length);
        elementos = novoArray;
    }
} 