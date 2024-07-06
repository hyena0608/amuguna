package com.hyena.selffinance.context

/**
 * @Description
 * @Owner hyunseo
 * @Date 6/30/24
 */
class ThreadLocalContext private constructor(
    private val threadLocal: ThreadLocal<MutableMap<String, Any>> = ThreadLocal<MutableMap<String, Any>>()
) {
    fun get(key: String): Any? {
        return threadLocal.get()[key]
    }

    fun set(key: String, value: Any) {
        threadLocal.get()[key] = value
    }

    fun remove(key: String){
        if (threadLocal.get().containsKey(key)) {
            threadLocal.get().remove(key)
        }
    }

    fun removeAll() {
        threadLocal.remove()
    }

    companion object {
        fun getContext(): ThreadLocalContext {
            return ThreadLocalContext()
        }
    }
}
