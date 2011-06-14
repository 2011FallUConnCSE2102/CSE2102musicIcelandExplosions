VERSION 5.00
Begin VB.Form ChordSearch 
   Caption         =   "Form3"
   ClientHeight    =   4755
   ClientLeft      =   60
   ClientTop       =   345
   ClientWidth     =   5610
   LinkTopic       =   "Form3"
   ScaleHeight     =   4755
   ScaleWidth      =   5610
   StartUpPosition =   3  'Windows Default
   Begin VB.Frame Frame3 
      Caption         =   "Tuning"
      Height          =   735
      Left            =   120
      TabIndex        =   21
      Top             =   3960
      Width           =   5415
      Begin VB.ComboBox Combo3 
         Height          =   315
         Left            =   120
         TabIndex        =   22
         Text            =   "Combo3"
         Top             =   240
         Width           =   5175
      End
   End
   Begin VB.Frame Frame2 
      Caption         =   "SearchResults"
      Height          =   3735
      Left            =   3120
      TabIndex        =   7
      Top             =   240
      Width           =   2415
      Begin VB.PictureBox Picture1 
         Height          =   1695
         Left            =   120
         ScaleHeight     =   1635
         ScaleWidth      =   2115
         TabIndex        =   14
         Top             =   1920
         Width           =   2175
      End
      Begin VB.ListBox List1 
         Height          =   1620
         Left            =   120
         TabIndex        =   8
         Top             =   240
         Width           =   2175
      End
   End
   Begin VB.Frame Frame1 
      Caption         =   "ChordParameters"
      Height          =   3735
      Left            =   120
      TabIndex        =   0
      Top             =   240
      Width           =   2895
      Begin VB.TextBox Text4 
         Height          =   285
         Left            =   2400
         TabIndex        =   19
         Text            =   "Text1"
         Top             =   1320
         Width           =   375
      End
      Begin VB.TextBox Text3 
         Height          =   285
         Left            =   2400
         TabIndex        =   17
         Text            =   "Text1"
         Top             =   960
         Width           =   375
      End
      Begin VB.CheckBox Check4 
         Caption         =   "AllowExtractChords"
         Height          =   255
         Left            =   120
         TabIndex        =   16
         Top             =   2400
         Width           =   2655
      End
      Begin VB.CheckBox Check3 
         Caption         =   "AllowBrokenChords"
         Height          =   255
         Left            =   120
         TabIndex        =   15
         Top             =   2760
         Width           =   2655
      End
      Begin VB.CommandButton Command1 
         Caption         =   "Search"
         Height          =   375
         Left            =   600
         TabIndex        =   13
         Top             =   3240
         Width           =   1695
      End
      Begin VB.ComboBox Combo2 
         Height          =   315
         Left            =   1080
         TabIndex        =   10
         Text            =   "Combo2"
         Top             =   480
         Width           =   1695
      End
      Begin VB.ComboBox Combo1 
         Height          =   315
         Left            =   120
         TabIndex        =   9
         Text            =   "Combo1"
         Top             =   480
         Width           =   855
      End
      Begin VB.CheckBox Check2 
         Caption         =   "Inversions"
         Height          =   255
         Left            =   120
         TabIndex        =   6
         Top             =   2040
         Width           =   2655
      End
      Begin VB.CheckBox Check1 
         Caption         =   "AllowOpenStrings"
         Height          =   255
         Left            =   120
         TabIndex        =   5
         Top             =   1680
         Width           =   2535
      End
      Begin VB.TextBox Text2 
         Height          =   285
         Left            =   960
         TabIndex        =   4
         Text            =   "Text1"
         Top             =   1320
         Width           =   375
      End
      Begin VB.TextBox Text1 
         Height          =   285
         Left            =   960
         TabIndex        =   2
         Text            =   "Text1"
         Top             =   960
         Width           =   375
      End
      Begin VB.Label Label6 
         Caption         =   "MinNote"
         Height          =   255
         Left            =   1440
         TabIndex        =   20
         Top             =   1320
         Width           =   975
      End
      Begin VB.Label Label5 
         Caption         =   "FrameFrets"
         Height          =   255
         Left            =   1440
         TabIndex        =   18
         Top             =   960
         Width           =   975
      End
      Begin VB.Label Label4 
         Caption         =   "Type"
         Height          =   255
         Left            =   1080
         TabIndex        =   12
         Top             =   240
         Width           =   1695
      End
      Begin VB.Label Label3 
         Caption         =   "Root"
         Height          =   255
         Left            =   120
         TabIndex        =   11
         Top             =   240
         Width           =   1695
      End
      Begin VB.Label Label2 
         Caption         =   "MaxFret"
         Height          =   255
         Left            =   120
         TabIndex        =   3
         Top             =   1320
         Width           =   735
      End
      Begin VB.Label Label1 
         Caption         =   "MinFret"
         Height          =   255
         Left            =   120
         TabIndex        =   1
         Top             =   960
         Width           =   735
      End
   End
   Begin VB.Label Label7 
      Caption         =   "Powerd By DenzoSOFT"
      Height          =   255
      Left            =   3360
      TabIndex        =   23
      Top             =   0
      Width           =   2175
   End
End
Attribute VB_Name = "ChordSearch"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False
