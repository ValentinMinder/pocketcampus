// Copyright (c) PocketCampus.Org 2014
// See LICENSE file for more details
// File author: Solal Pirelli

using PocketCampus.News.Models;
using ThinMvvm;

// Design data for FeedItemViewModel

namespace PocketCampus.News.ViewModels.Design
{
    public sealed class DesignFeedItemViewModel
    {
#if DEBUG
        public DataStatus DataStatus { get { return DataStatus.DataLoaded; } }
        public CacheStatus CacheStatus { get { return CacheStatus.Unused; } }

        public FeedItemContent ItemContent
        {
            get
            {
                return new FeedItemContent
                {
                    FeedName = "Général",
                    Title = "L'EPFL au plus profond de la «jungle aux robots» de Londres",
                    Url = "http://actu.epfl.ch/news/l-epfl-au-plus-profond-de-la-jungle-aux-robots-de-",
                    ImageUrl = "http://actu.epfl.ch/image/19310/{x}x{y}.jpg",
                    Content = @"<div>
29.11.13 - Le robot-chat et les salamandres robotiques créées à Lausanne s'aventurent ce week-end dans la jungle robotique du Musée de la science de Londres. Ses visiteurs sont invités à prendre part à un «safari robotique», à la rencontre des plus étonnants spécimens sortis des laboratoires de toute l’Europe.<br />
<p>C'est à un voyage bien particulier que les visiteurs du <em>London Science Museum </em>sont invités ce week-end. L'exposition Robot Safari EU rassemble treize robots bio-inspirés, issus de laboratoires de recherche du Royaume-Uni et d'Europe continentale. ""Il ne s'agit pas seulement de voir comment la nature inspire la robotique, mais aussi comment ces robots biomimétiques nous permettent de mieux comprendre le monde animal et végétal qu'ils imitent"", explique Nicola Burghall, l'une des responsables de l'exposition.</p> <p>L'EPFL contribue largement au dépaysement puisqu'elle s'y présente avec plusieurs spécimens. Les chercheurs lausannois du laboratoire Biorob se servent notamment de ces modèles pour étudier le système nerveux, en reproduisant son fonctionnement pour faire marcher ou nager une salamandre robotique. A terme, ces travaux pourraient permettre le développement de thérapies pour des blessures de la moelle épinière ou de prothèses plus performantes. Les robots de l'EPFL participent au Robot Safari EU grâce au soutien de NCCR Robotics.</p> <p>Petite visite en images (photos: © EPFL / Hillary Sanctuary)...</p> <p><img width=""400"" height=""601"" alt="""" src=""http://actu.epfl.ch/public/upload/fckeditorimage/5c/9b/80ac3c58.jpg"" /><br /> <em>Au-delà de ce portique, vous pénétrez dans la jungle des robots bio-inspirés...</em></p> <p><img width=""600"" height=""399"" alt="""" src=""http://actu.epfl.ch/public/upload/fckeditorimage/a5/41/f06bd331.jpg"" /><br /> <em>Les roboticiens de l'EPFL</em> <em>Massimo Vespignani (g.) et Peter Eckert expliquent aux visiteurs le fonctionnement de Cheetah-cub, le robot-chat.</em></p> <p><br /> <img width=""600"" height=""399"" alt="""" src=""http://actu.epfl.ch/public/upload/fckeditorimage/81/79/973fc1f4.jpg"" /><br /> <em>Derniers ajustements avant la mise à l'eau de Salamandra Robotica II.</em></p> <p><img width=""600"" height=""399"" alt="""" src=""http://actu.epfl.ch/public/upload/fckeditorimage/28/a7/2accdeb9.jpg"" /><br /> <em>Alessandro Crespi prépare la salamandre robotique pour le bain.</em></p> <p><img width=""600"" height=""399"" alt="""" src=""http://actu.epfl.ch/public/upload/fckeditorimage/a6/6b/abaa0e32.jpg"" /><br /> <em>Les ambassadeurs de l'EPFL entourent Pleurobot, Cheetah-cub et Salamandra robotica II. De g. à dr.: Auke Ijspeert, Massimo Vespignani, Robin Thandiackal, Peter Eckert, Kostas Karakasiliotis et Alessandro Crespi.</em></p>
</div>"
                };
            }
        }
#endif
    }
}