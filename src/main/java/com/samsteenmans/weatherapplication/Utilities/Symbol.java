package com.samsteenmans.weatherapplication.Utilities;

public class Symbol {

    public String getWeatherSymbolURL(long weatherCondition) {
        String weatherSymbolURL;

        // switch statement to check size
        switch ((int) weatherCondition) {
            case 1000: //Sunny
                weatherSymbolURL = "src/main/resources/com/samsteenmans/weatherapplication/weather/WhiteIcons/sun4.png";
                break;

            case 1003: // Partly Cloudy
                weatherSymbolURL = "src/main/resources/com/samsteenmans/weatherapplication/weather/WhiteIcons/clouds.png";
                break;

            case 1006: // Cloudy
            case 1009: // Overcast
                weatherSymbolURL = "src/main/resources/com/samsteenmans/weatherapplication/weather/WhiteIcons/cloudy.png";
                break;

            case 1030: // Partly Cloudy
                weatherSymbolURL = "src/main/resources/com/samsteenmans/weatherapplication/weather/WhiteIcons/partlycloudyday.png";
                break;

            case 1063: // Patchy Rain Possible
            case 1066: // Patchy Snow Possible
            case 1069: // Patchy Sleet Possible
            case 1114: // Blowing Snow
            case 1210: // Patchy Light Snow
            case 1213: // Light Snow
                weatherSymbolURL = "src/main/resources/com/samsteenmans/weatherapplication/weather/WhiteIcons/littlesnow.png";
                break;

            case 1087: // Thundery Outbreaks possible
                weatherSymbolURL = "src/main/resources/com/samsteenmans/weatherapplication/weather/WhiteIcons/chanceofstorm.png";
                break;

            case 1117: // Blizzard
            case 1279: // Patchy Light Snow With Thunder
            case 1282: // Moderate Or Heavy Snow With Thunder
                weatherSymbolURL = "src/main/resources/com/samsteenmans/weatherapplication/weather/WhiteIcons/snowstorm.png";
                break;

            case 1135: // Fog
            case 1147: // Freezing fog
                weatherSymbolURL = "src/main/resources/com/samsteenmans/weatherapplication/weather/WhiteIcons/fogday.png";
                break;

            case 1150: // Patchy Little Rain
            case 1153: // Light Drizzle
            case 1180: // Patchy light Rain
            case 1183: // Light Rain
            case 1240: // Light Rain Shower
                weatherSymbolURL = "src/main/resources/com/samsteenmans/weatherapplication/weather/WhiteIcons/littlerain.png";
                break;

            case 1168: // Freezing Drizzle
            case 1171: // Heavy Freezing Drizzle
            case 1198: // Light Freezing Rain
            case 1237: // Ice Pellets
            case 1261: // Light Showers Of Ice Pellets
            case 1264: // Moderate Or Heavy Showers Of Ice Pellets
                weatherSymbolURL = "src/main/resources/com/samsteenmans/weatherapplication/weather/WhiteIcons/icy.png";
                break;

            case 1189: // Moderate Rain
                weatherSymbolURL = "src/main/resources/com/samsteenmans/weatherapplication/weather/WhiteIcons/rainyweather.png";
                break;

            case 1192: // Heavy Rain At Times
            case 1195: // Heavy Rain
            case 1201: // Moderate Or Heavy Freezing Rain
            case 1243: // Moderate Or Heavy Rainshower
            case 1246: // Torrential Rain Shower
                weatherSymbolURL = "src/main/resources/com/samsteenmans/weatherapplication/weather/WhiteIcons/rain.png";
                break;

            case 1216: // Patchy Moderate Snow
            case 1219: // Moderate Snow
            case 1222: // Patchy Heavy Snow
            case 1225: // Heavy Snow
                weatherSymbolURL = "src/main/resources/com/samsteenmans/weatherapplication/weather/WhiteIcons/snow.png";
                break;

            case 1249: // Light Sleet Shower
            case 1252: // Moderate or Heavy Sleet Showers
            case 1255: // Light Snow Showers
            case 1258: // Moderate Or Heavy Snow Showers
                weatherSymbolURL = "src/main/resources/com/samsteenmans/weatherapplication/weather/WhiteIcons/sleet.png";
                break;

            case 1273: // Patchy Light Rain With Thunder
            case 1276: // Moderate Or Heavy Rain With Thunder
                weatherSymbolURL = "src/main/resources/com/samsteenmans/weatherapplication/weather/WhiteIcons/storm.png";
                break;

            default:
                weatherSymbolURL = "src/main/resources/com/samsteenmans/weatherapplication/weather/WhiteIcons/moon.png";
                break;
        }
        return weatherSymbolURL;
    }
}
