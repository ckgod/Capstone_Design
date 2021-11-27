package com.ckg.appletree.utils.listener

import android.util.Log
import com.ckg.appletree.ui.fragment.chat.ChatRoomFragment
import okhttp3.Response
import okhttp3.WebSocket
import okhttp3.WebSocketListener
import okhttp3.internal.notify
import okio.ByteString

interface WebHandler{
    fun receive(text : String)
}

class WebSocketListener : WebSocketListener() {
    lateinit var listener: WebHandler

    fun setHandler(handler: WebHandler) {
        this.listener = handler
    }

    override fun onOpen(webSocket: WebSocket, response: Response) {
        Log.d("Socket","Open")
    }

    override fun onMessage(webSocket: WebSocket, text: String) {
        listener.receive(text)
        Log.d("Socket","Receiving : $text")
    }

    override fun onMessage(webSocket: WebSocket, bytes: ByteString) {
        Log.d("Socket", "Receiving bytes : $bytes")

    }

    override fun onClosing(webSocket: WebSocket, code: Int, reason: String) {
        Log.d("Socket","Closing : $code / $reason")
        webSocket.close(NORMAL_CLOSURE_STATUS, null)
        webSocket.cancel()
    }

    override fun onFailure(webSocket: WebSocket, t: Throwable, response: Response?) {
        Log.d("Socket","Error : " + t.message)
    }

    companion object {
        private const val NORMAL_CLOSURE_STATUS = 1000
    }
}