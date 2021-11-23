package com.ckg.appletree.fragment.chat

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.ViewModel
import com.ckg.appletree.ApplicationClass
import org.json.JSONObject
import ua.naiksoftware.stomp.Stomp
import ua.naiksoftware.stomp.dto.LifecycleEvent
import ua.naiksoftware.stomp.dto.StompHeader

class ChatViewModel :ViewModel() {
    val jwtToken: String? = ApplicationClass.spToken?.getString(ApplicationClass.X_ACCESS_TOKEN, null)
    // val url = "http://example.com:8080/"
    var url = "ws://15.165.77.58:80/stomp/chat/websocket"
    val stompClient =  Stomp.over(Stomp.ConnectionProvider.OKHTTP, url)

    @SuppressLint("CheckResult")
    fun runStomp(){
        stompClient.connect()

//        val headerList = arrayListOf<StompHeader>()
//        headerList.add(StompHeader("chatRoomId","1"))
//        headerList.add(StompHeader("sender", "ckgod"))
//        headerList.add(StompHeader("content", "tesetsetsteset"))

        stompClient.topic("/subscribe/stomp/message").subscribe { topicMessage ->
            Log.d("message Recieve", topicMessage.payload)
        }

        stompClient.lifecycle().subscribe { lifecycleEvent ->
            when (lifecycleEvent.type) {
                LifecycleEvent.Type.OPENED -> {
                    Log.d(TAG, "open")
                }
                LifecycleEvent.Type.CLOSED -> {
                    Log.d(TAG, "close")

                }
                LifecycleEvent.Type.ERROR -> {
                    Log.d(TAG, "error")
                    Log.d(TAG, lifecycleEvent.exception.toString())
                }
                else ->{
                    Log.d(TAG, "else $lifecycleEvent.message")
                }
            }
        }

//            val data = JSONObject()
//            data.put("chatRoomId", "1")
//            data.put("sender", "dasdf")
//            data.put("content", "test")
//
//            stompClient.send("/publish/stomp/message", data.toString()).subscribe()

    }

    companion object{
        const val TAG = "ChatViewModel"
    }
}