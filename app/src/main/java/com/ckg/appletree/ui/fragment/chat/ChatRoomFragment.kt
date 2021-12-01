package com.ckg.appletree.ui.fragment.chat

import android.content.Context
import android.util.Log
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.ckg.appletree.R
import com.ckg.appletree.api.model.WebSocketRequest
import com.ckg.appletree.ui.base.BaseKotlinFragment
import com.ckg.appletree.databinding.FragmentChatRoomBinding
import com.ckg.appletree.ui.activity.MainActivity
import com.ckg.appletree.ui.fragment.zAdapter.MessageAdapter
import com.ckg.appletree.ui.fragment.zItem.TextMessage
import com.ckg.appletree.utils.listener.WebHandler
import com.ckg.appletree.utils.listener.WebSocketListener
import com.google.gson.JsonObject
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.WebSocket
import org.json.JSONObject


class ChatRoomFragment() : BaseKotlinFragment<FragmentChatRoomBinding>() {

    override val layoutResourceId: Int
        get() = R.layout.fragment_chat_room

    override val showBottomSheetFlag: Boolean
        get() = false

    private val viewModel by lazy { ChatViewModel() }
    lateinit var messageList: MutableList<TextMessage>
    private lateinit var client: OkHttpClient
    private lateinit var webSocket: WebSocket
    private lateinit var sessionId: String

    lateinit var mainActivity: MainActivity

    override fun onAttach(context: Context)
    {
        super.onAttach(context)
        mainActivity = context as MainActivity

    } // 2. Context를 액티비티로 형변환해서 할당 mainActivity = context as MainActivity }


    override fun initStartView() {
        messageList = mutableListOf()

        binding.btnBack.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.btnMeSend.setOnClickListener {
            webSocket.send(WebSocketRequest("message", sessionId, binding.etMessage.text.toString(), "닉넹").toString())
//            webSocket.send("{\"type\":\"message\", \"sessionId\": \""+sessionId+"\", \"content\": \"" + binding.etMessage.text.toString() + "\"}");
            binding.etMessage.setText("")
        }

        binding.rvChat.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

        binding.rvChat.adapter = MessageAdapter(requireActivity(), requireContext(), messageList)
    }

    fun makeClient() {
        client = OkHttpClient()

        val request: Request = Request.Builder()
            //android loopback -> 10.0.2.2 ㅅㅂ.. 2시간짜리
            .url("ws://3.34.227.1/ws/chat")
            .build()

        val listener = WebSocketListener().apply {
            setHandler(object : WebHandler {
                override fun receive(text: String) {
                    var type = JSONObject(text).getString("type")
                    var mSessionId = JSONObject(text).getString("sessionId")
                    var content = JSONObject(text).getString("content")

                    if(type.equals("established")){
                        sessionId = mSessionId
                    } else  {
                        Log.d("ChatRoomFragment:", "mSessionId: " + mSessionId +" sessionId: " + sessionId)
                        if(mSessionId.equals(sessionId)) messageList.add(TextMessage(type,mSessionId,content,false))
                        else messageList.add(TextMessage(type,mSessionId,content,true))

                        mainActivity.runOnUiThread {
                            binding.rvChat.adapter?.notifyItemChanged(messageList.size-1)
                            binding.rvChat.scrollToPosition(messageList.size-1)
                        }

                    }
                }

            })
        }

        webSocket = client.newWebSocket(request, listener)
    }

    override fun initDataBinding() {

    }

    override fun initAfterBinding() {

    }

    override fun reLoadUI() {
        makeClient()
    }

    override fun onStop() {
        super.onStop()
        webSocket.close(1000, null)
    }

    fun setDummy() {
    }

    companion object {
        const val TAG = "ChatRoomFragment"
    }
}