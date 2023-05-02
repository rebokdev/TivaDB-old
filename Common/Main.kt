package dev.rebokdev.TivaDB

import com.soywiz.korio.file.VfsFile
import com.soywiz.korio.file.std.localVfs
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

suspend fun main() {
    val DataBaseUno = DB(localVfs("/home/rebok/IdeaProjects/TivaDB/DBs/DBUNO.TvDB"))
}




class DB(DBFile: VfsFile) {
    init {
        println("ez")
        
    }
    class DBObject(vararg val parameters: Pair<String,Any>) {
        val ParameterMap: Map<String,Any> = mapOf(*parameters)
        operator fun get(Index: String): Message {
            if (ParameterMap[Index] != null) {
                return Message(ParameterMap[Index], DBError())
            } else {
                return Message(null, DBError("1x1x1", mapOf("ErrorMessage" to "Trying to get not existant entry from DBObject.","Parameter" to Index,"FullData" to ParameterMap)))
            }
        }
    }

    class Message(val Content: Any?, val Error: DBError) {
        fun getMessageContent(): Any? { return Content }
        fun getMessageError(): DBError { return Error }
    }

    class DBError(val ErrorCode: String = "0x0x0",val Details: Map<String,Any> = mapOf()) {
        fun GetErrorCode(): String { return ErrorCode }
        operator fun get(Index: String): Any? { return Details[Index] }
    }

    val DBSaveObjectsQueue: MutableList<DBObject> = mutableListOf()
}
