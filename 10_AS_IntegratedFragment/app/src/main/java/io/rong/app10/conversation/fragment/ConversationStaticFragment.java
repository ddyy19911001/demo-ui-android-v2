package io.rong.app10.conversation.fragment;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import io.rong.app10.App;
import io.rong.app10.R;
import io.rong.imkit.fragment.ConversationFragment;


/**
 * Created by Bob on 15/7/28.
 *
 *  会话页面静态集成 fragment
 */
public class ConversationStaticFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.conversation,container,false);

        ConversationFragment fragment = (ConversationFragment) getChildFragmentManager().findFragmentById(R.id.conversation);

        Uri uri = Uri.parse("rong://" + getActivity().getApplicationInfo().packageName).buildUpon()
                .appendPath("conversation").appendPath(io.rong.imlib.model.Conversation.ConversationType.PRIVATE.getName().toLowerCase())
                .appendQueryParameter("targetId", App.mTargetID).appendQueryParameter("title", "hello").build();
        fragment.setUri(uri);

        return  view;
    }
}
