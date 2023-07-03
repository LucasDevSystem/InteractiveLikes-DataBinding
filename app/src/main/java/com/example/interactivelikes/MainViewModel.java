package com.example.interactivelikes;

import androidx.databinding.ObservableInt;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


public class MainViewModel extends ViewModel {
    private int likesCounter = 0;
    // Variaveis de binding
    public ObservableInt progress = new ObservableInt();
    public ObservableInt imagemLikes = new ObservableInt();
    private MutableLiveData<String> sobrenome = new MutableLiveData<String>("");
    private MutableLiveData<String> nome = new MutableLiveData<String>("");


    public MainViewModel() {
        imagemLikes.set(getNextImg());
    }

    public MutableLiveData<String> getNome() {
        return nome;
    }

    public MutableLiveData<String> getSobrenome() {
        return sobrenome;
    }

    public ObservableInt ImagemLikes() {
        return imagemLikes;
    }


    public ObservableInt getProgress() {
        return progress;
    }

    private int getNextImg() {
        if (likesCounter <= 3) {
            return R.drawable.img_like;
        } else if (likesCounter >= 4 && likesCounter <= 8) {
            return R.drawable.img_coracao;
        } else if (likesCounter >= 9) {
            return R.drawable.img_fogo;
        }

        return R.drawable.img_like;
    }

    public int getLikes() {
        return likesCounter;
    }

    public void darLike() {
        int nextProgress = progress.get() + 10;
        likesCounter++;

        progress.set(nextProgress);
        imagemLikes.set(getNextImg());
    }

}