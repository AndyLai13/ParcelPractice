package com.andylai.parcelpractice;

import android.os.Parcel;
import android.os.Parcelable;

public class ParcelObject implements Parcelable {
    int pbInt;
    String pbString;
    SimpleParcel simpleParcel;
    ExtendParcel extendParcel;

    public ParcelObject(int pbInt, String pbString, SimpleParcel simpleParcel, ExtendParcel extendParcel) {
        this.pbInt = pbInt;
        this.pbString = pbString;
        this.simpleParcel = simpleParcel;
        this.extendParcel = extendParcel;
    }

    protected ParcelObject(Parcel in) {
        pbInt = in.readInt();
        pbString = in.readString();
        simpleParcel = in.readParcelable(SimpleParcel.class.getClassLoader());
        extendParcel = in.readParcelable(ExtendParcel.class.getClassLoader());
    }

    public static final Creator<ParcelObject> CREATOR = new Creator<ParcelObject>() {
        @Override
        public ParcelObject createFromParcel(Parcel in) {
            return new ParcelObject(in);
        }

        @Override
        public ParcelObject[] newArray(int size) {
            return new ParcelObject[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(pbInt);
        dest.writeString(pbString);
        dest.writeParcelable(simpleParcel, flags);
        dest.writeParcelable(extendParcel, flags);
    }

    public static class SimpleParcel implements Parcelable {
        int spInt;
        String spString;

        public SimpleParcel(int spInt, String spString) {
            this.spInt = spInt;
            this.spString = spString;
        }

        protected SimpleParcel(Parcel in) {
            spInt = in.readInt();
            spString = in.readString();
        }

        public static final Creator<SimpleParcel> CREATOR = new Creator<SimpleParcel>() {
            @Override
            public SimpleParcel createFromParcel(Parcel in) {
                return new SimpleParcel(in);
            }

            @Override
            public SimpleParcel[] newArray(int size) {
                return new SimpleParcel[size];
            }
        };

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(spInt);
            dest.writeString(spString);
        }
    }

    public static abstract class AbstractParcel implements Parcelable {
        int apInt;

        AbstractParcel(int apInt) {
            this.apInt = apInt;
        }

        protected AbstractParcel(Parcel in) {
            apInt = in.readInt();
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(apInt);
        }

        @Override
        public int describeContents() {
            return 0;
        }
    }

    public static class ExtendParcel extends AbstractParcel {
        int epInt;
        String epString;

        ExtendParcel(int apInt, int epInt, String epString) {
            super(apInt);
            this.epInt = epInt;
            this.epString = epString;
        }

        protected ExtendParcel(Parcel in) {
            super(in);
            epInt = in.readInt();
            epString = in.readString();
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            super.writeToParcel(dest, flags);
            dest.writeInt(epInt);
            dest.writeString(epString);
        }

        public static final Parcelable.Creator<ExtendParcel> CREATOR = new Parcelable.Creator<ExtendParcel>() {
            public ExtendParcel createFromParcel(Parcel in) {
                return new ExtendParcel(in);
            }

            public ExtendParcel[] newArray(int size) {
                return new ExtendParcel[size];
            }
        };
    }
}
