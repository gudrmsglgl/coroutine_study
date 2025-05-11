package section13.code1

class AddUseCase {
    fun add(vararg args: Int): Int {
        return args.sum()
    }
}