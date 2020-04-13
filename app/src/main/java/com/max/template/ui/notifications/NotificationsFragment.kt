package com.max.template.ui.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.max.template.R
import com.tencent.liteav.demo.play.SuperPlayerModel
import com.tencent.liteav.demo.play.SuperPlayerVideoId
import com.tencent.liteav.demo.play.SuperPlayerView

class NotificationsFragment : Fragment() {

    private lateinit var notificationsViewModel: NotificationsViewModel
    private lateinit var mSuperPlayerView: SuperPlayerView

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        notificationsViewModel =
                ViewModelProviders.of(this).get(NotificationsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_notifications, container, false)
        val textView: TextView = root.findViewById(R.id.text_notifications)
        notificationsViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        mSuperPlayerView = root.findViewById(R.id.superVodPlayerView)

        playVideo()

        return root
    }

    private fun playVideo() {
        val model = SuperPlayerModel()
        model.appId = 1300529239 // 配置 AppId

        model.videoId = SuperPlayerVideoId()
        model.videoId.fileId = "5285890801266691277" // 配置 FileId

        mSuperPlayerView.playWithModel(model)
    }
}
