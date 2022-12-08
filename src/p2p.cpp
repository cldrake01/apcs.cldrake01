//
//  p2p.cpp
//  
//
//  Created by Collin Drake on 12/3/22.

// Chrome version:

/*
* #!/bin/bash
*
* #Download the image
* wget https://www.peaktopeak.org/cms/lib/CO02222769/Centricity/Shared/Staff%20Photos/JOSH%20BENSON-cropped.jpg
*
* #Set the image as the wallpaper
* gsettings set org.gnome.desktop.background picture-uri file:///home/JOSH%20BENSON-cropped.jpg
*/

#include <stdio.h>
#include <Windows.h>
#include <wininet.h>
#pragma comment(lib, "wininet.lib")

#define URL "https://www.peaktopeak.org/cms/lib/CO02222769/Centricity/Shared/Staff%20Photos/JOSH%20BENSON-cropped.jpg"

int main()
{
    // Initialize WinInet
    HINTERNET hInternet = InternetOpen(NULL, INTERNET_OPEN_TYPE_PRECONFIG, NULL, NULL, 0);
    if (hInternet == NULL)
    {
        printf("Error: Could not initialize WinInet\n");
        return 1;
    }

    // Open the URL
    HINTERNET hURL = InternetOpenUrl(hInternet, URL, NULL, 0, 0, 0);
    if (hURL == NULL)
    {
        printf("Error: Could not open URL\n");
        InternetCloseHandle(hInternet);
        return 1;
    }

    // Read the data
    char buffer[1024];
    DWORD bytesRead;
    HANDLE hFile = CreateFile("wallpaper.jpg", GENERIC_WRITE, 0, NULL, CREATE_ALWAYS, FILE_ATTRIBUTE_NORMAL, NULL);
    if (hFile == INVALID_HANDLE_VALUE)
    {
        printf("Error: Could not create file\n");
        InternetCloseHandle(hURL);
        InternetCloseHandle(hInternet);
        return 1;
    }

    while (InternetReadFile(hURL, buffer, sizeof(buffer), &bytesRead) && bytesRead > 0)
    {
        WriteFile(hFile, buffer, bytesRead, &bytesRead, NULL);
    }

    // Set the wallpaper
    SystemParametersInfo(SPI_SETDESKWALLPAPER, 0, (PVOID)"wallpaper.jpg", SPIF_UPDATEINIFILE);

    // Clean up
    CloseHandle(hFile);
    InternetCloseHandle(hURL);
    InternetCloseHandle(hInternet);

    return 0;
}
