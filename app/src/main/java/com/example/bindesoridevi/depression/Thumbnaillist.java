package com.example.bindesoridevi.depression;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import android.os.Bundle;
import android.provider.MediaStore.Video.Thumbnails;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
/**
 * Created by BINDESORI DEVI on 22-06-2016.
 */
public class Thumbnaillist extends ListActivity {

    String[] videoFileList = {
            "/storage/sdcard1/WhatsApp/Media/WhatsApp Video/abc.mp4",
            "/storage/sdcard1/WhatsApp/Media/WhatsApp Video/xyz.mp4"
    };
    String[] namelist1 = {
            "Video1",
            "Video2"
    };
    String[] namelist2 = {
            "Video3",
            "Video4"
    };


    public class MyThumbnaildapter extends ArrayAdapter<String> {

        public MyThumbnaildapter(Context context, int textViewResourceId, String[] objects) {

            super(context, textViewResourceId, objects);
            // TODO Auto-generated constructor stub
        }


        public View getView(int position, View convertView, ViewGroup parent) {
            // TODO Auto-generated method stub
            int a= getIntent().getIntExtra("v",0);
            switch (a) {
                case 1:
                    View row1 = convertView;
                    if (row1 == null) {
                        LayoutInflater inflater = getLayoutInflater();
                        row1 = inflater.inflate(R.layout.vidrow, parent, false);
                    }

                    TextView textfilePath1 = (TextView) row1.findViewById(R.id.nm);
                    textfilePath1.setText(namelist1[position]);
                    ImageView imageThumbnail1 = (ImageView) row1.findViewById(R.id.Thumbnail);

                    Bitmap bmThumbnail;
                    bmThumbnail = ThumbnailUtils.createVideoThumbnail(videoFileList[position], Thumbnails.MICRO_KIND);
                    imageThumbnail1.setImageBitmap(bmThumbnail);

//                    return row1;

                case 2:
                    View row2 = convertView;
                    if (row2 == null) {
                        LayoutInflater inflater = getLayoutInflater();
                        row2 = inflater.inflate(R.layout.vidrow, parent, false);
                    }

                    TextView textfilePath2 = (TextView) row2.findViewById(R.id.nm);
                    textfilePath2.setText(namelist2[position]);
                    ImageView imageThumbnail2 = (ImageView) row2.findViewById(R.id.Thumbnail);

                    Bitmap bmThumbnail2;
                    bmThumbnail2 = ThumbnailUtils.createVideoThumbnail(videoFileList[position], Thumbnails.MICRO_KIND);
                    imageThumbnail2.setImageBitmap(bmThumbnail2);

  //                  return row2;

                case 3:
                    View row3 = convertView;
                    if (row3 == null) {
                        LayoutInflater inflater = getLayoutInflater();
                        row3 = inflater.inflate(R.layout.vidrow, parent, false);
                    }

                    TextView textfilePath3 = (TextView) row3.findViewById(R.id.nm);
                    textfilePath3.setText(namelist1[position]);
                    ImageView imageThumbnail3 = (ImageView) row3.findViewById(R.id.Thumbnail);

                    Bitmap bmThumbnail3;
                    bmThumbnail3 = ThumbnailUtils.createVideoThumbnail(videoFileList[position], Thumbnails.MICRO_KIND);
                    imageThumbnail3.setImageBitmap(bmThumbnail3);

    //                return row3;
                                case 4:
                    View row4 = convertView;
                    if (row4 == null) {
                        LayoutInflater inflater = getLayoutInflater();
                        row4 = inflater.inflate(R.layout.vidrow, parent, false);
                    }

                    TextView textfilePath4 = (TextView) row4.findViewById(R.id.nm);
                    textfilePath4.setText(namelist1[position]);
                    ImageView imageThumbnail4 = (ImageView) row4.findViewById(R.id.Thumbnail);

                    Bitmap bmThumbnail4;
                    bmThumbnail4 = ThumbnailUtils.createVideoThumbnail(videoFileList[position], Thumbnails.MICRO_KIND);
                    imageThumbnail4.setImageBitmap(bmThumbnail4);

      //              return row4;


            }

            return convertView;
        }
    }




    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int a= getIntent().getIntExtra("v",0);
        if (a == 1) {
            setListAdapter(new MyThumbnaildapter(Thumbnaillist.this, R.layout.vidrow, videoFileList));
        } else if (a == 2) {
            setListAdapter(new MyThumbnaildapter(Thumbnaillist.this, R.layout.vidrow, videoFileList));
        } else if (a == 3) {
            setListAdapter(new MyThumbnaildapter(Thumbnaillist.this, R.layout.vidrow, videoFileList));
        } else if (a == 4) {
            setListAdapter(new MyThumbnaildapter(Thumbnaillist.this, R.layout.vidrow, videoFileList));
        }
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        int a= getIntent().getIntExtra("v",0);
        if (a == 1) {
            super.onListItemClick(l, v, position, id);
            if (position == 0) {
                Intent i = new Intent(this, utube.class);
                i.putExtra("p", position);
                startActivity(i);
            } else if (position == 1) {
                Intent i = new Intent(this, utube.class);
                i.putExtra("p", position);
                startActivity(i);
            }
        }
        else if (a == 2) {
            super.onListItemClick(l, v, position, id);
            if (position == 0) {
                Intent i = new Intent(this, utube.class);
                i.putExtra("p", position);
                startActivity(i);
            } else if (position == 1) {
                Intent i = new Intent(this, utube.class);
                i.putExtra("p", position);
                startActivity(i);
            }
        }
        if (a == 3) {
            super.onListItemClick(l, v, position, id);
            if (position == 0) {
                Intent i = new Intent(this, utube.class);
                i.putExtra("p", position);
                startActivity(i);
            } else if (position == 1) {
                Intent i = new Intent(this, utube.class);
                i.putExtra("p", position);
                startActivity(i);
            }
        }
        else if (a == 4) {
            super.onListItemClick(l, v, position, id);
            if (position == 0) {
                Intent i = new Intent(this, utube.class);
                i.putExtra("p", position);
                startActivity(i);
            } else if (position == 1) {
                Intent i = new Intent(this, utube.class);
                i.putExtra("p", position);
                startActivity(i);
            }
        }
    }
}

