package org.jackzeng.rxjava;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

import java.time.LocalDateTime;

/**
 * @author zengxj
 * @create 2018/2/1
 */
public class MultiDataSource {

    private Observable<BaseDataSource> cache = Observable.create( // ObservableOnSubscribe
            // emmit item when subscribe happen
            emitter -> {
                emitter.onNext(new BaseDataSource("emit at " + LocalDateTime.now().toString()));
                //emitter.onComplete(); if onComplete() is invoked then the Observer will not receive emit msg anymore
                //emitter.onError(); if onError() is invoked then the Observer will not receive emit msg anymore
                try {
                    int x = 10 / (1-2);
                } catch (Exception e) {
                    emitter.onError(e);
                }

                emitter.onNext(new BaseDataSource("second emit at " + LocalDateTime.now().toString()));
            });

    public void init() {
        // simple consumer act onNext, just consume the item emit from Observable<BaseDataSource>
        cache.subscribe(data -> System.out.println("s1 " + data.getInfo()));

        // if cache() then the other subscribe() will share the same as pre-subscribe emit item
        cache.cache();

        Disposable handler = null;
        //onNext, onError, onComplete
        cache.subscribe(
                data -> System.out.println("s2 " +  data.getInfo()), //onNext
                throwable -> System.out.println(throwable.toString()), //onError
                () -> System.out.println("onComplete"), //onComplete
                disposable -> System.out.println(disposable.isDisposed())
        );

        cache.subscribe(new Observer<BaseDataSource>() {
            private Disposable disposable;

            @Override
            public void onSubscribe(Disposable d) { //just call once
                this.disposable = d;
            }

            @Override
            public void onNext(BaseDataSource baseDataSource) {
                System.out.println("s3 " + baseDataSource.getInfo());
                //cancel the subscribe the data source
                //will not invoked by emitter anymore
                disposable.dispose();
            }

            @Override
            public void onError(Throwable e) {
                System.out.println(e.toString());
            }

            @Override
            public void onComplete() {
                System.out.println("complete");
            }
        });

    }

    private Observable<BaseDataSource> network;

    public void get() {
        Observable.concat(cache, network)
                .first(null);

        network.doOnNext(data -> {
        });
    }

    public static void main(String[] args) {
        MultiDataSource m = new MultiDataSource();
        m.init();
    }
}
