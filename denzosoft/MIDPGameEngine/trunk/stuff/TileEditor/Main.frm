VERSION 5.00
Begin VB.Form Main 
   Caption         =   "Form1"
   ClientHeight    =   10800
   ClientLeft      =   165
   ClientTop       =   735
   ClientWidth     =   13560
   LinkTopic       =   "Form1"
   ScaleHeight     =   720
   ScaleMode       =   3  'Pixel
   ScaleWidth      =   904
   StartUpPosition =   3  'Windows Default
   Begin VB.CommandButton Command4 
      Caption         =   "Command4"
      Height          =   375
      Left            =   8160
      TabIndex        =   21
      Top             =   10320
      Width           =   1215
   End
   Begin VB.CommandButton Command3 
      Caption         =   "Command3"
      Height          =   495
      Left            =   8160
      TabIndex        =   20
      Top             =   9720
      Width           =   1215
   End
   Begin VB.PictureBox Picture7 
      AutoRedraw      =   -1  'True
      AutoSize        =   -1  'True
      BorderStyle     =   0  'None
      Height          =   975
      Left            =   8400
      ScaleHeight     =   975
      ScaleWidth      =   975
      TabIndex        =   19
      Top             =   7800
      Width           =   975
   End
   Begin VB.PictureBox Picture6 
      AutoRedraw      =   -1  'True
      BorderStyle     =   0  'None
      Height          =   480
      Left            =   8400
      ScaleHeight     =   480
      ScaleWidth      =   480
      TabIndex        =   18
      Top             =   7080
      Width           =   480
   End
   Begin VB.CommandButton Command2 
      Caption         =   "Command2"
      Height          =   375
      Left            =   6240
      TabIndex        =   17
      Top             =   10320
      Width           =   1815
   End
   Begin VB.CommandButton Command1 
      Caption         =   "Command1"
      Height          =   495
      Left            =   6240
      TabIndex        =   16
      Top             =   9720
      Width           =   1815
   End
   Begin VB.PictureBox Picture5 
      AutoRedraw      =   -1  'True
      Height          =   3855
      Left            =   9480
      ScaleHeight     =   3795
      ScaleWidth      =   3795
      TabIndex        =   13
      Top             =   6840
      Width           =   3855
   End
   Begin VB.TextBox Text4 
      Alignment       =   1  'Right Justify
      Height          =   285
      Left            =   4320
      TabIndex        =   12
      Top             =   10080
      Width           =   1215
   End
   Begin VB.TextBox Text3 
      Alignment       =   1  'Right Justify
      Height          =   285
      Left            =   4320
      TabIndex        =   10
      Top             =   9720
      Width           =   1215
   End
   Begin VB.TextBox Text2 
      Alignment       =   1  'Right Justify
      Height          =   285
      Left            =   1560
      TabIndex        =   8
      Text            =   "32"
      Top             =   10080
      Width           =   1215
   End
   Begin VB.TextBox Text1 
      Alignment       =   1  'Right Justify
      Height          =   285
      Left            =   1560
      TabIndex        =   6
      Text            =   "32"
      Top             =   9720
      Width           =   1215
   End
   Begin VB.PictureBox Picture3 
      Height          =   6735
      Left            =   0
      ScaleHeight     =   445
      ScaleMode       =   3  'Pixel
      ScaleWidth      =   885
      TabIndex        =   1
      Top             =   0
      Width           =   13335
      Begin VB.VScrollBar VScroll2 
         Height          =   6735
         Left            =   13080
         TabIndex        =   3
         Top             =   0
         Width           =   255
      End
      Begin VB.PictureBox Picture4 
         AutoRedraw      =   -1  'True
         AutoSize        =   -1  'True
         BorderStyle     =   0  'None
         Height          =   3615
         Left            =   0
         ScaleHeight     =   241
         ScaleMode       =   3  'Pixel
         ScaleWidth      =   617
         TabIndex        =   2
         Top             =   0
         Width           =   9255
      End
   End
   Begin VB.PictureBox Picture1 
      AutoRedraw      =   -1  'True
      Height          =   2895
      Left            =   0
      ScaleHeight     =   189
      ScaleMode       =   3  'Pixel
      ScaleWidth      =   541
      TabIndex        =   0
      Top             =   6720
      Width           =   8175
      Begin VB.VScrollBar VScroll1 
         Height          =   2655
         LargeChange     =   32
         Left            =   7920
         SmallChange     =   4
         TabIndex        =   15
         Top             =   0
         Width           =   255
      End
      Begin VB.HScrollBar HScroll1 
         Height          =   255
         Left            =   0
         TabIndex        =   14
         Top             =   2640
         Width           =   7935
      End
      Begin VB.PictureBox Picture2 
         AutoRedraw      =   -1  'True
         AutoSize        =   -1  'True
         BorderStyle     =   0  'None
         Height          =   2175
         Left            =   0
         ScaleHeight     =   145
         ScaleMode       =   3  'Pixel
         ScaleWidth      =   385
         TabIndex        =   4
         Top             =   0
         Width           =   5775
      End
   End
   Begin VB.Label Label4 
      Caption         =   "Map Height"
      Height          =   255
      Left            =   2880
      TabIndex        =   11
      Top             =   10080
      Width           =   1335
   End
   Begin VB.Label Label3 
      Caption         =   "Map Width"
      Height          =   255
      Left            =   2880
      TabIndex        =   9
      Top             =   9720
      Width           =   1335
   End
   Begin VB.Label Label2 
      Caption         =   "Tile Height"
      Height          =   255
      Left            =   120
      TabIndex        =   7
      Top             =   10080
      Width           =   1335
   End
   Begin VB.Label Label1 
      Caption         =   "Tile Width"
      Height          =   255
      Left            =   120
      TabIndex        =   5
      Top             =   9720
      Width           =   1335
   End
   Begin VB.Menu mnuFile 
      Caption         =   "File"
      Begin VB.Menu mnuOpenTile 
         Caption         =   "Open Tile..."
      End
      Begin VB.Menu mnuOpenTileImage 
         Caption         =   "Open Tile Image..."
      End
      Begin VB.Menu mnuSaveTile 
         Caption         =   "Save Tile..."
      End
      Begin VB.Menu mnuExit 
         Caption         =   "Exit"
      End
   End
End
Attribute VB_Name = "Main"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False
Private Declare Function StretchBlt Lib "gdi32" (ByVal hDestDC As Long, ByVal DestX As Long, ByVal DestY As Long, ByVal nDestWidth As Long, ByVal nDestHeight As Long, ByVal hSrcDC As Long, ByVal xSrc As Long, ByVal ySrc As Long, ByVal nSrcWidth As Long, ByVal nSrcHeight As Long, ByVal dwRop As Long) As Long
Private Enum RasterOps
SRCCOPY = &HCC0020
SRCAND = &H8800C6
SRCINVERT = &H660046
SRCPAINT = &HEE0086
SRCERASE = &H4400328
WHITENESS = &HFF0062
BLACKNESS = &H42
End Enum

Private Sub Command1_Click()
Picture4.Width = 32 * 16 + 0
Picture4.Height = 32 * 20 + 0


    For i = 0 To 15
        For o = 0 To 19
            StretchBlt Picture4.hDC, i * 32, o * 32, 32, 32, Picture2.hDC, i * 34, o * 34, 32, 32, SRCCOPY
            
        Next o
    Next i
    Picture4.Refresh
    SavePicture Picture4.Image, App.Path + "/new.bmp"
End Sub

Private Sub Command2_Click()
    Picture2.Picture = LoadPicture(App.Path + "/guy.gif")

    Counter = 0
    For i = 0 To 7
        For o = 0 To 2
            StretchBlt Picture6.hDC, 0, 0, 32, 32, Picture2.hDC, o * 32, i * 32, 32, 32, SRCCOPY
            Picture6.Refresh
            SavePicture Picture6.Image, App.Path + "/img" + Format(Counter, "000") + ".bmp"
            Counter = Counter + 1
        Next o
    Next i

End Sub

Private Sub Command3_Click()
    Picture4.Width = 176
    Picture4.Height = 139 * 11
    
    
    For i = 0 To 10
        Picture7.Picture = LoadPicture(App.Path + "/_s" + Format(i) + ".gif")
        Picture7.Refresh
        StretchBlt Picture4.hDC, 0, 139 * i, 176, 139, Picture7.hDC, 0, 0, 176, 139, SRCCOPY
        
        
        
    Next i
    Picture4.Refresh
    
    SavePicture Picture4.Image, App.Path + "/circuit.bmp"
End Sub

Private Sub Command4_Click()
    Picture4.Width = 32 * 9
    Picture4.Height = 32 * 2
    For i = 0 To 18
        StretchBlt Picture4.hDC, (i Mod 9) * 32, Int(i / 9) * 32, 32, 32, Picture2.hDC, Int((i + 99) Mod 10) * 32, Int((i + 99) / 10) * 32, 32, 32, SRCCOPY
    Next i
    Picture4.Refresh
    SavePicture Picture4.Image, App.Path + "/explosions.bmp"
    
End Sub

Private Sub Form_Load()
    Picture2.Picture = LoadPicture(App.Path + "/Sprites.bmp")
    
End Sub



Private Sub HScroll1_Change()
    Picture2.Left = -Main.HScroll1.Value
    
End Sub

Private Sub Picture2_MouseDown(Button As Integer, Shift As Integer, X As Single, Y As Single)
    StretchBlt Picture5.hDC, 0, 0, Picture5.Width, Picture5.Height, Picture2.hDC, Int(X / 32) * 32, Int(Y / 32) * 32, 32, 32, SRCCOPY
    Picture5.Refresh
    
End Sub

Private Sub Picture2_Resize()
    Main.VScroll1.Max = Picture2.Height - Picture1.Height + 16
    
    Main.VScroll1.Min = 0
    
    Main.VScroll1.Value = 0
    
    Main.HScroll1.Max = Picture2.Width - Picture1.Width + 16
    
    
    
    
End Sub

Private Sub VScroll1_Change()
    Picture2.Top = -VScroll1.Value
    
    
End Sub
