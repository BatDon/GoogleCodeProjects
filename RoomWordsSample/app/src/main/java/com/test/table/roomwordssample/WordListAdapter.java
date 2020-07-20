package com.test.table.roomwordssample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.ViewHolder> {
    List<Word> words;
    LayoutInflater mInflater;

    WordListAdapter(Context context) {
        this.mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public WordListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.recyclerview_item, parent, false);
        return new ViewHolder(view);
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        ViewHolder(View view){
            super(view);
            textView=view.findViewById(R.id.textView);
        }

    }

    @Override
    public void onBindViewHolder(@NonNull WordListAdapter.ViewHolder holder, int position) {
        if(words!=null){
            Word word=words.get(position);
            String wordString=word.getWord();
            holder.textView.setText(wordString);
        }
        else{
            holder.textView.setText("no word");
        }

    }

    @Override
    public int getItemCount() {
        if(words!=null){
            return words.size();
        }
        else{
            return 0;
        }
    }

    void setWords(List<Word> words){
        this.words = words;
        notifyDataSetChanged();
    }
}
