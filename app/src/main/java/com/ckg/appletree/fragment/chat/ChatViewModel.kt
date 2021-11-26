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


    companion object{
        const val TAG = "ChatViewModel"
    }
}